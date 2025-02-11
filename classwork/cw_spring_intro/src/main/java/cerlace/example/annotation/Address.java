package cerlace.example.annotation;

import cerlace.example.autowired.IAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Component("addressAnnotation")
public class Address implements IAddress {
//    @Value("#{'1'}")
    private String id;
//    @Value("#{'Minsk'}")
    private String city;
//    @Value("#{'Brovki'}")
    private String street;
//    @Value("#{'10'}")
    private String house;
}