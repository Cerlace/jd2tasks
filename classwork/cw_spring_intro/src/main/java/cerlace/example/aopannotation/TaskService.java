package cerlace.example.aopannotation;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public void performJob() {
        System.out.println("Doing job...");
    }

    public void performExceptionJob() throws Throwable {
        System.out.println("Doing job with exception...");
        throw new Exception();
    }

    public String performJobAround() {
        System.out.println("Doing job around...");
        return "SUCCESS";
    }

    public void performJob(String name) {
        System.out.println("Doing job " + name);
    }
}
