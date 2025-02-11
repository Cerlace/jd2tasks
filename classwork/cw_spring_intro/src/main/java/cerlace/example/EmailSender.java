package cerlace.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailSender implements ISender {

    private String address;

    @Override
    public void send(String message) {
        System.out.println("email sent: " + message);
    }
}
