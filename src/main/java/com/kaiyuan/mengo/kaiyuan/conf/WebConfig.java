package com.kaiyuan.mengo.kaiyuan.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器，绝对地址与虚拟路径映射
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 绝对路径与虚拟路径映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:/home/front_dev/upload/");//注意路径前的file:
    }
    /**
    token拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/api/**", "/preview", "/my_upload")
                .excludePathPatterns("/api/loginAction", "/api/addUser", "/image/**");//去掉不需要token的请求
    }


}
