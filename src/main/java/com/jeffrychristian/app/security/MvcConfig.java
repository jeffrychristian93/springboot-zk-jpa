package com.jeffrychristian.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by jeffry.christian on 11/9/2016.
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/zul/");
		resolver.setSuffix(".zul");
		return resolver;
	}

}