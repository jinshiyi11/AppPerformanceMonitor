package com.seagle.performance.performance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PerformanceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PerformanceApplication.class);
    }

    //处理跨域问题
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/**.html").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/**.js").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/**.css").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/**.png").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/**.json").addResourceLocations("classpath:/static/");
//                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

                registry.addResourceHandler("/**").addResourceLocations("/", "classpath:/static/");
                super.addResourceHandlers(registry);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
