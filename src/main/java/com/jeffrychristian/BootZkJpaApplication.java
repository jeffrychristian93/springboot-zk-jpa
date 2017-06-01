package com.jeffrychristian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;

@SpringBootApplication
public class BootZkJpaApplication {

	/**
	 * 	For login example you can use bootzkjpa.sql
	 *
	 *  Username : admin
	 *  Password : sa
	 *
	 */

	public static void main(String[] args) {
		SpringApplication.run(BootZkJpaApplication.class, args);
	}

/*
	 * ZK servlets
	 * Null value was assigned to a property [class com.jeffrychristian.elastiz.domain.user.User.loginAttempt] of primitive type setter of com.jeffrychristian.elastiz.domain.user.User.loginAttempt; nested exception is org.hibernate.PropertyAccessException: Null value was assigned to a property [class com.jeffrychristian.elastiz.domain.user.User.loginAttempt] of primitive type setter of com.jeffrychristian.elastiz.domain.user.User.loginAttempt
	 */

	@Bean
	public ServletRegistrationBean zkLoader() {
		ServletRegistrationBean zkLoader = new ServletRegistrationBean(new DHtmlLayoutServlet(), "*.zul", "*.zhtml");
		zkLoader.getInitParameters().put("update-uri", "/zkau");
		return zkLoader;
	}

	@Bean
	public ServletRegistrationBean auEngine() {
		ServletRegistrationBean auEngine = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
		return auEngine;
	}

	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}
}
