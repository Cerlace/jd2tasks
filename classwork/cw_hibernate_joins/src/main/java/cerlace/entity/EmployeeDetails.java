package cerlace.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@Setter
@ToString(exclude = "employee")
@EqualsAndHashCode(exclude = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_details")
@Entity
public class EmployeeDetails implements Serializable {

    @GenericGenerator(name = "one-one",
                    strategy = "foreign",
                    parameters = @Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    @Id
    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String street;

    @Column
    private String state;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Employee employee;
}
