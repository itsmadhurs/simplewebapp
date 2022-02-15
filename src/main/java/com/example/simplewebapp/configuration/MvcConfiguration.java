package com.example.simplewebapp.configuration;


import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/").resourceChain(false);
    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return (factory) -> factory.setRegisterDefaultServlet(true);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages");
        resolver.setSuffix(".html");
        return resolver;
    }

    /*@Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        try {
            configurer.setLocations(new PathMatchingResourcePatternResolver().getResources("file:/var/codedeploy/tomcat-sample/env.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load resources.", e);
        }
        return configurer;
    }*/
}
