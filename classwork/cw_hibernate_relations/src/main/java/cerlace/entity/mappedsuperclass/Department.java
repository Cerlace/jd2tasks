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
public class Department extends DateEntity {
    @Column(name = "department_name")
    private String departmentName;
}
