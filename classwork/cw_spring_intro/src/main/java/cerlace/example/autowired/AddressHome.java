package cerlace.example.autowired;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressHome implements IAddress {
    private String id;
    private String city;
    private String street;
    private String house;
}
