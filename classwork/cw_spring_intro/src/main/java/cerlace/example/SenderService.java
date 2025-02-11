package cerlace.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SenderService {

    private ISender sender;

    public void send(String message) {
        sender.send(message);
    }
}
