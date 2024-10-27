import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            HelloClass instance = HelloClass.class.getConstructor().newInstance();
            Method method = HelloClass.class.getDeclaredMethod("printHelloWorld");
            method.setAccessible(true);
            method.invoke(instance);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
