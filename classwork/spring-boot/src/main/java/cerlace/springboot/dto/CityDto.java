package cerlace.springboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityDto {
    private Integer id;
    @NotBlank(message = "Name must be not blank")
    private String name;
    private String location;
}
