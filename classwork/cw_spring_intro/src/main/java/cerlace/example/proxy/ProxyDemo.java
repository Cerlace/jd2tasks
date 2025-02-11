package cerlace.example.proxy;

import org.springframework.aop.framework.ProxyFactory;

public class ProxyDemo {

    private static TransferService transferService = new TransferService();

    private static TransferService transferServiceProxy;

    public static void main(String[] args) {
        init();
        TransferData transferData = TransferData.builder()
                .amount("15")
                .fromCard("1234")
                .toCard("4321")
                .build();
        System.out.println(transferService.transfer(transferData));
        System.out.println(transferServiceProxy.transfer(transferData));
    }

    private static void init() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new CreditSniffer());
        proxyFactory.setTarget(transferService);
        transferServiceProxy = (TransferService) proxyFactory.getProxy();
    }
}
