package cerlace.example.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CreditSniffer implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        TransferData argumentForChange = (TransferData) arguments[0];
        argumentForChange.setFromCard("2323");
        return methodInvocation.proceed();
    }
}
