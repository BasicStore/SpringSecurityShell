package com.security.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        
        
        
        // TODO remove this
        registry.addViewController("/home").setViewName("zuser");
        
        registry.addViewController("/user").setViewName("zuser");
        
     	registry.addViewController("/member").setViewName("rmember");
        
     	
    	registry.addViewController("/admin").setViewName("radmin");
    	
    	registry.addViewController("/admin2").setViewName("radmin2");
    	
    	
    	
        
    }

}