package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MeasureTimeAspect {
    @Around("@annotation(MeasuringTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toString();

        long start = System.currentTimeMillis();
        Object returnedByMethod = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        System.out.println("Method " + methodName + " completed in " + elapsedTime + " ms");

        return returnedByMethod;
    }
}
