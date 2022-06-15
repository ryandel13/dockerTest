package com.example.testappa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Configuration
@Component
public class Configs {
    
    @Value("${test-app-a.labels.test-label}")
    @Getter
    private String testLabel;

}
