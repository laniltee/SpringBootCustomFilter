package com.pearson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomFilterApplication {

	@Bean
	public FilterRegistrationBean xAuthorizationFilter(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new XAuthFilter());
		filterRegistrationBean.addUrlPatterns("/api/*");
		return  filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomFilterApplication.class, args);
	}
}
