package cerlace.entity.mappedsuperclass;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee extends DateEntity {
    @Column
    private String name;
    @Column
    private Double salary;
}
