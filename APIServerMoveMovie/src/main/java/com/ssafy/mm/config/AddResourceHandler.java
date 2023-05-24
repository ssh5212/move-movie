package com.ssafy.mm.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AddResourceHandler implements WebMvcConfigurer {

	@Value("${file.Path.profile}")
    private String profileImagePath;
	
	@Value("${request.Path.profile}")
	private String profilerequest;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(profilerequest)
                .addResourceLocations("file:///" + profileImagePath + File.separator)
                .setCachePeriod(60 * 10)
                .resourceChain(true);
    }
}
