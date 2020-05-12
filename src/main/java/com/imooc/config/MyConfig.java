package com.imooc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @author xjj
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/upload.html").setViewName("/upload");
            }
        };
        return webMvcConfigurer;
    }

//    /**
//     * 文件上传配置
//     *
//     * @return
//     */
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //  单个数据大小
//        factory.setMaxFileSize("10240MB"); // KB,MB
//        /// 总上传数据大小
//        factory.setMaxRequestSize("102400MB");
//        return factory.createMultipartConfig();
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 其中的路径写的是文件保存的路径，可以直接将file:/后面的内容全部进行替换 */
//        registry.addResourceHandler("/Path/**").addResourceLocations("file:/C:/upload");
        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\upload");
    }
}
