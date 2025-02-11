package cerlace.example.aoptask;

import org.springframework.stereotype.Component;

@Component
public class HrServiceImpl implements HrService{
    @Override
    public void findEmployee(String experience) {
        System.out.println("Ищем сотрудника с опытом " + experience);
    }
}
