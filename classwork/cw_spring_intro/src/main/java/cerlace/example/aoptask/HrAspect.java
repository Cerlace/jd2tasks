package cerlace.example.aoptask;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HrAspect {

    @Pointcut("execution( * cerlace.example.aoptask.HrService.findEmployee(String)) && args(experience)")
    public void findEmployee(String experience) {
    }

    @Before(value = "findEmployee(experience)", argNames = "experience")
    public void before(String experience) {
        System.out.println("Начинам поиск кандитата, необходимый опыт: " + experience);
    }

    @Around("findEmployee(String)")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Начали поиск в " + System.currentTimeMillis());
            joinPoint.proceed();
            System.out.println("Закончили поиск в " + System.currentTimeMillis());
        } catch (Throwable ignored) {
        }
    }

    @After(value = "findEmployee(experience)", argNames = "experience")
    public void after(String experience) {
        System.out.println("Закончили поиск кандитата, его опыт: " + experience);
    }
}
