package com.office.library.bookrentalpjt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${org.file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String resourcePath = "/libraryUploadImg/**";
        String savePath = uploadPath;

        registry.addResourceHandler(resourcePath).addResourceLocations("file://" + savePath);
    }
}
