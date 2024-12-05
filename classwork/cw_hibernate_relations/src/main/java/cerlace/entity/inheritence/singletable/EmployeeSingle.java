package cerlace.entity.inheritence.singletable;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table
@DiscriminatorValue("E")
public class EmployeeSingle extends PersonSingle {

    @Column
    private String company;
    @Column
    private Double salary;
}
