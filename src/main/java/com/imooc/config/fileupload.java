package com.imooc.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class fileupload {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小  测试后从配置取值。
        factory.setMaxFileSize("102400MB"); // KB,MB
        /// 总上传数据大小
        factory.setMaxRequestSize("1024000MB");
        return factory.createMultipartConfig();
    }
}
