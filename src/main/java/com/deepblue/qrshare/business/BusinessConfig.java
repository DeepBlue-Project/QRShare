package com.deepblue.qrshare.business;

import com.deepblue.qrshare.business.conversion.Base64Converter;
import com.deepblue.qrshare.business.generation.QRGenerator;
import com.deepblue.qrshare.business.generation.TokenGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    public QRGenerator qrGenerator() {
        return new QRGenerator();
    }

    @Bean
    public Base64Converter base64Converter() {
        return new Base64Converter();
    }

    @Bean
    public TokenGenerator tokenGenerator() {
        return new TokenGenerator();
    }
}
