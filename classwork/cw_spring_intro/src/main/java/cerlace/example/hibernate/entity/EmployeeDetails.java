package cerlace.example.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
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
                    parameters = @Parameter(name = "property",
                    value = "employee"))
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
