package com.shabab.atm.common;


import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
/**
 *
 * @author Yash
 */
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomApiErrorDecoder();
    }
}
