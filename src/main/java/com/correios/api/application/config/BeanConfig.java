package com.correios.api.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.web.client.RestTemplate;

import javax.xml.parsers.DocumentBuilderFactory;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldAccessLevel(AccessLevel.PRIVATE);

        return modelMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
