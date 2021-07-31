package com.example.onlineShop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Аспект для логирования вызовов методов контроллера
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.onlineShop.controller..*.*(..))")
    private void getName() {
    }

    @Before("getName()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.printf("Вызван метод: %s%n", joinPoint);
    }
}
