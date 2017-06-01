package com.jeffrychristian.app.security;

import org.springframework.aop.framework.autoproxy.AutoProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProviders;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.expression.MapAccessor;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeffry.christian on 11/20/2016.
 */

/**
 * {@link EnableAutoConfiguration Auto-configuration} to render errors via an MVC error
 * controller.
 *
 * @author Dave Syer
 * @author Andy Wilkinson
 * @author Stephane Nicoll
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
// Load before the main WebMvcAutoConfiguration so that the error View is available
@AutoConfigureBefore(WebMvcAutoConfiguration.class)
@EnableConfigurationProperties(ResourceProperties.class)
public class ErrorMvcAutoConfiguration {

    private final ApplicationContext applicationContext;

    private final ServerProperties serverProperties;

    private final ResourceProperties resourceProperties;

    @Autowired(required = false)
    private List<ErrorViewResolver> errorViewResolvers;

    public ErrorMvcAutoConfiguration(ApplicationContext applicationContext,
                                     ServerProperties serverProperties, ResourceProperties resourceProperties) {
        this.applicationContext = applicationContext;
        this.serverProperties = serverProperties;
        this.resourceProperties = resourceProperties;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
    public DefaultErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes();
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorController.class, search = SearchStrategy.CURRENT)
    public BasicErrorController basicErrorController(ErrorAttributes errorAttributes) {
        return new BasicErrorController(errorAttributes, this.serverProperties.getError(),
                this.errorViewResolvers);
    }

    @Bean
    public ErrorPageCustomizer errorPageCustomizer() {
        return new ErrorPageCustomizer(this.serverProperties);
    }

    @Bean
    @ConditionalOnBean(DispatcherServlet.class)
    @ConditionalOnMissingBean
    public DefaultErrorViewResolver conventionErrorViewResolver() {
        return new DefaultErrorViewResolver(this.applicationContext,
                this.resourceProperties);
    }

    @Bean
    public static PreserveErrorControllerTargetClassPostProcessor preserveErrorControllerTargetClassPostProcessor() {
        return new PreserveErrorControllerTargetClassPostProcessor();
    }

    @Configuration
    @ConditionalOnProperty(prefix = "server.error.whitelabel", name = "enabled", matchIfMissing = true)
    @Conditional(ErrorTemplateMissingCondition.class)
    protected static class WhitelabelErrorViewConfiguration {

        private final SpelView defaultErrorView = new SpelView(
                "<html>" +
                        "<body>" +
                            "<h1>Error bro</h1>"
                            + "<p>Anda salah alamat..~</p>"
                            + "<div id='created'>${timestamp}</div>"
                            + "<div>Tipe error : (types=${error}, status=${status}).</div>"
                            + "<br></br>"
                            + "<div>by <a href='https://www.facebook.com/jeffrychristian93' target='_blank'>~JC~</a></div>" +
                        "</body>" +
                "</html>");

        @Bean(name = "error")
        @ConditionalOnMissingBean(name = "error")
        public View defaultErrorView() {
            return this.defaultErrorView;
        }

        // If the user adds @EnableWebMvc then the bean name view resolver from
        // WebMvcAutoConfiguration disappears, so add it back in to avoid disappointment.
        @Bean
        @ConditionalOnMissingBean(BeanNameViewResolver.class)
        public BeanNameViewResolver beanNameViewResolver() {
            BeanNameViewResolver resolver = new BeanNameViewResolver();
            resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
            return resolver;
        }

    }

    /**
     * {@link SpringBootCondition} that matches when no error template view is detected.
     */
    private static class ErrorTemplateMissingCondition extends SpringBootCondition {

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context,
                                                AnnotatedTypeMetadata metadata) {
            ConditionMessage.Builder message = ConditionMessage
                    .forCondition("ErrorTemplate Missing");
            TemplateAvailabilityProviders providers = new TemplateAvailabilityProviders(
                    context.getClassLoader());
            TemplateAvailabilityProvider provider = providers.getProvider("error",
                    context.getEnvironment(), context.getClassLoader(),
                    context.getResourceLoader());
            if (provider != null) {
                return ConditionOutcome
                        .noMatch(message.foundExactly("template from " + provider));
            }
            return ConditionOutcome
                    .match(message.didNotFind("error template view").atAll());
        }

    }

    /**
     * Simple {@link View} implementation that resolves variables as SpEL expressions.
     */
    private static class SpelView implements View {

        private final PropertyPlaceholderHelper helper;

        private final String template;

        private volatile Map<String, Expression> expressions;

        SpelView(String template) {
            this.helper = new PropertyPlaceholderHelper("${", "}");
            this.template = template;
        }

        @Override
        public String getContentType() {
            return "text/html";
        }

        @Override
        public void render(Map<String, ?> model, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
            if (response.getContentType() == null) {
                response.setContentType(getContentType());
            }
            Map<String, Object> map = new HashMap<String, Object>(model);
            map.put("path", request.getContextPath());
            PlaceholderResolver resolver = new ExpressionResolver(getExpressions(), map);
            String result = this.helper.replacePlaceholders(this.template, resolver);
            response.getWriter().append(result);
        }

        private Map<String, Expression> getExpressions() {
            if (this.expressions == null) {
                synchronized (this) {
                    ExpressionCollector expressionCollector = new ExpressionCollector();
                    this.helper.replacePlaceholders(this.template, expressionCollector);
                    this.expressions = expressionCollector.getExpressions();
                }
            }
            return this.expressions;
        }

    }

    /**
     * {@link PlaceholderResolver} to collect placeholder expressions.
     */
    private static class ExpressionCollector implements PlaceholderResolver {

        private final SpelExpressionParser parser = new SpelExpressionParser();

        private final Map<String, Expression> expressions = new HashMap<String, Expression>();

        @Override
        public String resolvePlaceholder(String name) {
            this.expressions.put(name, this.parser.parseExpression(name));
            return null;
        }

        public Map<String, Expression> getExpressions() {
            return Collections.unmodifiableMap(this.expressions);
        }

    }

    /**
     * SpEL based {@link PlaceholderResolver}.
     */
    private static class ExpressionResolver implements PlaceholderResolver {

        private final Map<String, Expression> expressions;

        private final EvaluationContext context;

        ExpressionResolver(Map<String, Expression> expressions, Map<String, ?> map) {
            this.expressions = expressions;
            this.context = getContext(map);
        }

        private EvaluationContext getContext(Map<String, ?> map) {
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.addPropertyAccessor(new MapAccessor());
            context.setRootObject(map);
            return context;
        }

        @Override
        public String resolvePlaceholder(String placeholderName) {
            Expression expression = this.expressions.get(placeholderName);
            return escape(expression == null ? null : expression.getValue(this.context));
        }

        private String escape(Object value) {
            return HtmlUtils.htmlEscape(value == null ? null : value.toString());
        }

    }

    /**
     * {@link EmbeddedServletContainerCustomizer} that configures the container's error
     * pages.
     */
    private static class ErrorPageCustomizer implements ErrorPageRegistrar, Ordered {

        private final ServerProperties properties;

        protected ErrorPageCustomizer(ServerProperties properties) {
            this.properties = properties;
        }

        @Override
        public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
            ErrorPage errorPage = new ErrorPage(this.properties.getServletPrefix()
                    + this.properties.getError().getPath());
            errorPageRegistry.addErrorPages(errorPage);
        }

        @Override
        public int getOrder() {
            return 0;
        }

    }

    /**
     * {@link BeanFactoryPostProcessor} to ensure that the target class of ErrorController
     * MVC beans are preserved when using AOP.
     */
    static class PreserveErrorControllerTargetClassPostProcessor
            implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
                throws BeansException {
            String[] errorControllerBeans = beanFactory
                    .getBeanNamesForType(ErrorController.class, false, false);
            for (String errorControllerBean : errorControllerBeans) {
                try {
                    beanFactory.getBeanDefinition(errorControllerBean).setAttribute(
                            AutoProxyUtils.PRESERVE_TARGET_CLASS_ATTRIBUTE, Boolean.TRUE);
                }
                catch (Throwable ex) {
                    // Ignore
                }
            }
        }

    }

}
