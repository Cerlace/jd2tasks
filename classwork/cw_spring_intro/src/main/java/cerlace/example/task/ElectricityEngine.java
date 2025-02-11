package cerlace.example.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
//@Component
public class ElectricityEngine implements IEngine {
    private String value;
    private String type;

//    @Autowired
    public ElectricityEngine(
//            @Value(value = ("500 mW"))
            String value,
//            @Value(value = ("electricity"))
            String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void gas() {
        System.out.println("Electricity Engine type " + type + " value " + value);
    }
}
