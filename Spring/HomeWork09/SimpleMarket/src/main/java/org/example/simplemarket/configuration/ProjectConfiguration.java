package org.example.simplemarket.configuration;


import org.example.simplemarket.aspects.LoggingAspect;
import org.example.simplemarket.aspects.MeasureTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example.simplemarket.services")
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
