package cerlace.example.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Work {

    @Pointcut("execution( * cerlace.example.aopannotation.TaskService.performJob())")
    public void performance() {

    }

    @Pointcut("execution( * cerlace.example.aopannotation.TaskService.performExceptionJob())")
    public void performanceException() {

    }

    @Pointcut("execution( * cerlace.example.aopannotation.TaskService.performExceptionJob(String)) && args(name)")
    public void intercept(String name) {

    }

    @Before("performance()")
    public void beforeWork() {
        System.out.println("Before work");
    }
    @AfterReturning("performance()")
    public void afterWork() {
        System.out.println("After work");
    }
    @AfterThrowing("performanceException()")
    public void afterThrowingWork() {
        System.out.println("After work throwing");
    }

    @Around("performance()")
    public void aroundWork(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Start");
            System.out.println("time start: " + System.currentTimeMillis());
            joinPoint.proceed();
            System.out.println("time end: " + System.currentTimeMillis());
            System.out.println("End");
        } catch (Throwable e) {

        }
    }
    @Before("intercept(name)")
    public void interceptWork(String name) {
        System.out.println("Name" + name);
    }
}
