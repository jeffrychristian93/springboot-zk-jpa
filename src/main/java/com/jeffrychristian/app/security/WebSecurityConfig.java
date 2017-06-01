package com.jeffrychristian.app.security;

import com.jeffrychristian.app.domain.user.User;
import com.jeffrychristian.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.DelegatingLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
//        auth.inMemoryAuthentication().withUser("uuu").password("ppp").roles("USER");
    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionFixation().none();
        http.authorizeRequests()
                .antMatchers("/app**").access("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_ADMIN','ROLE_USER')")
                .anyRequest().permitAll()

                .and()
                .headers().frameOptions().disable()

                .and()
                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").successHandler(loginSuccessHandler()).failureUrl("/login?error=1")

                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").logoutSuccessHandler(logoutSuccessHandler()).invalidateHttpSession(true).deleteCookies()

                .and()
                .exceptionHandling().accessDeniedPage("/403")

                .and()
                .csrf().disable();
     }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }


    @Bean
    public DelegatingLogoutSuccessHandler logoutSuccessHandler() {
        LinkedHashMap<RequestMatcher, LogoutSuccessHandler> matcherToHandler = new LinkedHashMap<>();
        matcherToHandler.put(new MediaTypeRequestMatcher(new ParameterContentNegotiationStrategy(Collections.singletonMap("json", MediaType.APPLICATION_JSON)), MediaType.APPLICATION_JSON), new HttpStatusReturningLogoutSuccessHandler(HttpStatus.FOUND));
        DelegatingLogoutSuccessHandler delegatingLogoutSuccessHandler = new DelegatingLogoutSuccessHandler(matcherToHandler);
        delegatingLogoutSuccessHandler.setDefaultLogoutSuccessHandler(new SimpleUrlLogoutSuccessHandler());
        return delegatingLogoutSuccessHandler;
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return (httpServletRequest, httpServletResponse, authentication) -> {
            Date now = new Date();
            User user = userRepository.findByUserName(((User) authentication.getPrincipal()).getUserName());
            user.setSession(httpServletRequest.getSession().getId());
            user.setRemoteAddress(httpServletRequest.getRemoteAddr());
            user.setRemoteHost(httpServletRequest.getRemoteHost());
            user.setLoginDate(now);
            user.setLoginAttempt(1);
            userRepository.save(user);

            httpServletRequest.getSession().setAttribute("currentUser", user);

            //set response to OK status
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            //redirect the user after successfully login
            httpServletResponse.sendRedirect("app");
        };
    }
}