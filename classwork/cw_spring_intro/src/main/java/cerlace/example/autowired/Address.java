package cerlace.example.autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
public class Address implements IAddress {
    private String id;
    private String city;
    private String street;
    private String house;
}
