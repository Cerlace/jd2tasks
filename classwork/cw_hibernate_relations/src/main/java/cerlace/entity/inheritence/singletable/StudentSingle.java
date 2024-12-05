package cerlace.entity.inheritence.singletable;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table
@Entity
@DiscriminatorValue("S")
public class StudentSingle extends PersonSingle {

    private String faculty;
    private Double mark;
}
