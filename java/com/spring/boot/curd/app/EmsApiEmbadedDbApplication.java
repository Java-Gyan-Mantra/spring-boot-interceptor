package com.spring.boot.curd.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.boot.curd.app.logging.CustomInterceptor;

@SpringBootApplication
public class EmsApiEmbadedDbApplication extends WebMvcConfigurerAdapter {
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor()).addPathPatterns(
				"/EMS/*");
	}

	public static void main(String[] args) {
		SpringApplication.run(EmsApiEmbadedDbApplication.class, args);
	}
}
