/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author dc01spring9
 */
@Configuration
@EnableWebMvc
@ComponentScan("br.com.season.springproject")
public class SpringProjectConfig {
    
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
