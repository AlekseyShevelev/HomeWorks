package com.example.demo.configuration;

import com.example.demo.aspects.LoggingAspect;
import com.example.demo.aspects.MeasureTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.demo.services")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public LoggingAspect logging() {
        return new LoggingAspect();
    }

    @Bean
    public MeasureTimeAspect measureTime() {
        return new MeasureTimeAspect();
    }
}
