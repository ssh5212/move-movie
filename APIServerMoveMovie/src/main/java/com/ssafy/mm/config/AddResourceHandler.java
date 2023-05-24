package com.ssafy.mm.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AddResourceHandler implements WebMvcConfigurer {


	
	@Value("${request.Path.profile}")
	private String profilerequest;
	
	@Value("${request.Path.spotfile}")
	private String spotfilerequest;
	
	@Value("${request.Path.spotinst}")
	private String spotinstrequest;
	
	@Value("${file.Path.profile}")
	private String profileImagePath;
	
	@Value("${file.Path.spotfile}")
    private String spotfileImagePath;
	
	@Value("${file.Path.spotinst}")
    private String spotinstImagePath;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(profilerequest, spotfilerequest, spotinstrequest)
                .addResourceLocations("file:///" + profileImagePath + File.separator, "file:///" + spotfileImagePath + File.separator, "file:///" + spotinstImagePath + File.separator)
                .setCachePeriod(60 * 10)
                .resourceChain(true);
    }
}
