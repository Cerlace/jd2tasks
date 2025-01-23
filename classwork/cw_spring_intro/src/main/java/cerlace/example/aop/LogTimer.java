package cerlace.example.aop;

public class LogTimer {

    public void notifyBefore() {
        System.out.println(System.currentTimeMillis());
    }
    public void notifyAfter() {
        System.out.println(System.currentTimeMillis());
    }
}
