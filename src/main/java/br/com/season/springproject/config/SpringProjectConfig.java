/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.season.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 *
 * @author dc01spring9
 */
@Configuration
@EnableWebMvc
@ComponentScan("br.com.season.springproject")
public class SpringProjectConfig extends WebMvcConfigurerAdapter {
	@Bean
	public TilesConfigurer tilesConfigure() {

		TilesConfigurer tiles = new TilesConfigurer();

		tiles.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml" });
		tiles.setCheckRefresh(true);

		return tiles;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);

	} /*
		 * @Bean public ViewResolver viewResolver(){
		 * InternalResourceViewResolver viewResolver = new
		 * InternalResourceViewResolver();
		 * viewResolver.setPrefix("/WEB-INF/views/pages/");
		 * viewResolver.setSuffix(".jsp"); return viewResolver; }
		 */
}
