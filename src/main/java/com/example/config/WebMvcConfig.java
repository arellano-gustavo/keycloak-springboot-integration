package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
			
	@Autowired
	private CustomInterceptor customInterceptor;

	
    /**
     * {@inheritDoc}
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      logger.info("Setting up handlers for VueJS Locations");
      registry
          .addResourceHandler("index.html")
          .addResourceLocations("classpath:/dist/index.html");
      registry
          .addResourceHandler("/js/**")
          .addResourceLocations("classpath:/dist/js/");
      registry
      .addResourceHandler("/css/**")
      .addResourceLocations("classpath:/dist/css/");

    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customInterceptor);
	}
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry
       		.addMapping("/**")
       		.allowedOrigins("*")
       		.allowedMethods("GET", "POST","PUT", "DELETE");
    }
}