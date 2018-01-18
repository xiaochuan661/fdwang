package com.mine.product.fdwang.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public FastJsonHttpMessageConverter4 jsonHttpMessageConverter() {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

        //wangkun23 2017-3-9 修复BigDecimal如果是0.000000000 显示科学计数法问题
        jsonConfig.setSerializerFeatures(SerializerFeature.WriteBigDecimalAsPlain);

        converter.setFastJsonConfig(jsonConfig);
        return converter;
    }

    /**
     * REST 格式转换
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jsonHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    /**
     * Rest Template 模板配置
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(jsonHttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    /**
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
        super.addResourceHandlers(registry);
    }

    /**
     * 错误页面处理
     *
     * @return 错误信息
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
        };
    }

    /**
     * 解决跨域问题
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*").maxAge(86400);
        super.addCorsMappings(registry);
    }

}
