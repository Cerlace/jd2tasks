package cerlace.example.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
//@Component
public class GasEngine implements IEngine {
    private String value;
    private String type;

//    @Autowired
    public GasEngine(
//            @Value(value = ("100 cubic cm"))
            String value,
//            @Value(value = ("gas"))
            String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void gas() {
        System.out.println("Gas Engine type " + type + " value " + value);
    }
}
