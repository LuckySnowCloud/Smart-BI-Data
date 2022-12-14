package com.yun.bigateway.config;

import com.yun.bidatacommon.constant.CommonConstant;
import com.yun.bigateway.context.ContextThreadLocal;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.optionals.OptionalDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author Sober
 */
@Slf4j
@Configuration
public class FeignWebFluxConfig implements RequestInterceptor {

    /**
     * 默认connect timeout 10s，read timeout 60s
     *
     * @return
     */
    @Bean
    public Request.Options feignOptions() {
        return new Request.Options();
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(feignHttpMessageConverter());
    }

    @Bean
    public Decoder feignDecoder() {
        return new OptionalDecoder(
                new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter())));
    }

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        return () -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获得Token
        String token = ContextThreadLocal.getRequest().getHeader(CommonConstant.SMART_BI_TOKEN);
        // 写入传递
        requestTemplate.header(CommonConstant.SMART_BI_TOKEN, token);
    }

}
