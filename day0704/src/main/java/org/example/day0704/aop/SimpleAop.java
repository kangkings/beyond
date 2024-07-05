package org.example.day0704.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SimpleAop {
    @Pointcut("execution(* org.example.day0704.test..*.*(..))")
    private void cut(){
        System.out.println("cut");
    }

    @Before("cut()")

    public void before(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        System.out.println(joinPoint.getSignature());
        System.out.println(method.getName() + "메소드 실행");
    }
    @AfterReturning(value = "cut()", returning = "returnObject")
    public void afterReturning(JoinPoint joinPoint,Object returnObject){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        System.out.println(joinPoint.getSignature());
        System.out.println(method.getName()+"메소드 실행 전");
        System.out.println(returnObject.getClass().getName() + "객체 반환");
    }


}
