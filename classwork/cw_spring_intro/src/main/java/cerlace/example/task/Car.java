package cerlace.example.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
//@Component
public class Car {
    private String vin;
    private String name;
    private String made;
    private IEngine engine;

    //    @Autowired
    public Car(
//            @Value(value = ("5N5424G32342J4343"))
            String vin,
//               @Value(value = ("Volkswagen"))
            String name,
//               @Value(value = ("Germany"))
            String made,
//               @Qualifier(value = "electricityEngine")
            IEngine engine) {
        this.vin = vin;
        this.name = name;
        this.made = made;
        this.engine = engine;
    }
}
