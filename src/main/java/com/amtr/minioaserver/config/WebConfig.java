package com.amtr.minioaserver.config;

import com.amtr.minioaserver.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginCheckInterceptor).excludePathPatterns("/user/login","/error");
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 允许所有请求源，也可以指定具体的请求源
        config.addAllowedOrigin("*");

        // 允许发送的请求方法
        config.addAllowedMethod("*");

        // 允许携带的头部信息
        config.addAllowedHeader("*");

        // 配置支持跨域的路径
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
