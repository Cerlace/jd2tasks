package cerlace.entity.inheritence.joined;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table
@Entity
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class StudentJoined extends PersonJoined {

    private String faculty;
    private Double mark;
}
