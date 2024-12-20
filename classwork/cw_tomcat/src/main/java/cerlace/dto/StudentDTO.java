package cerlace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String id;
    private String name;
    private String age;
    private String address;
    private String mark;
}
