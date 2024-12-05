package cerlace.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@ToString(exclude = "employees")
@EqualsAndHashCode(exclude = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet();
}
