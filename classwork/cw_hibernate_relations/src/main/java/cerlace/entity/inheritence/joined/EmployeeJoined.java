package cerlace.entity.inheritence.joined;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class EmployeeJoined extends PersonJoined {

    @Column
    private String company;
    @Column
    private Double salary;
}
