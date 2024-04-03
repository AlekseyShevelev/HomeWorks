package com.example.demo.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    @Before("@annotation(Loggable)")
    public void log(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toString();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("Вызван метод " + methodName +
                " с параметрами " + Arrays.asList(arguments));
    }
}
