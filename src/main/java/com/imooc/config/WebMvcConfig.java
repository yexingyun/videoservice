package com.imooc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <pre>
 * @Description:
 * @Aouth: cao_wencao
 * @Date: 2019-01-23 17:39
 * </pre>
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:C://upload/");
        registry.addResourceHandler("/videos/**").addResourceLocations("file:C://upload/");
    }
}
