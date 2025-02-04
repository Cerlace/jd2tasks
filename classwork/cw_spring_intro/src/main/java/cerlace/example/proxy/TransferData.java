package cerlace.example.proxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TransferData {
    private String fromCard;
    private String toCard;
    private String amount;
}
