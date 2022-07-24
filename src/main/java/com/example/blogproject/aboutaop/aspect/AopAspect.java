package com.example.blogproject.aboutaop.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AopAspect {

    @Around("execution(* com.example.blogproject.aboutaop..*.*(..))")
    public Object aopLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("============flow start============");
        Object name = joinPoint.getSignature();
        log.info("name = {} ",name);
        long end = System.currentTimeMillis();
        log.info("============endTime = {}============",(start-end));
        return joinPoint.proceed();
    }
}
