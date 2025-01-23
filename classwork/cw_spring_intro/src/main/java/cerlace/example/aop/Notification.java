package cerlace.example.aop;

import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;

@Setter
public class Notification {

    private String name;

    public void notifyBefore() {
        System.out.println("notified before");
    }

    public void notifyAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        final long finish = System.currentTimeMillis();
        System.out.println("proceeded in " + (finish - start) + " ms");
        System.out.println("sent from " + name);
    }

    public void notifyAfter() {
        System.out.println("notified after");
    }
}
