package com.codegym.student.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
public class MyLogger {
    @AfterReturning(pointcut = "within(com.codegym.student.service.student.*)", returning = "result")
    public void log(JoinPoint joinPoint, Object result) {
        System.out.println("[MyLogger] @AfterReturning ================================ ");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[MyLogger] executed %s.%s [args=%s]", className, methodName, args));
        String strResult = (result == null) ? "[null]" : result.toString();
        System.out.println("[MyLogger] Result: " + strResult);
    }

//    @Around("execution(public * com.codegym.student.service.student.*(..)))")
//    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
//    {
//        System.out.println("khoi dong");
//        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
//
//        //Get intercepted method details
//        String className = methodSignature.getDeclaringType().getSimpleName();
//        String methodName = methodSignature.getName();
//
//        final StopWatch stopWatch = new StopWatch();
//
//        //Measure method execution time
//        stopWatch.start();
//        Object result = proceedingJoinPoint.proceed();
//        stopWatch.stop();
//
//        System.out.println(className);
//        System.out.println(methodName);
//        //Log method execution time
////        LOGGER.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");
//
//        return result;
//    }



}
