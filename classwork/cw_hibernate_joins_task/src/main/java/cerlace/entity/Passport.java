package cerlace.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "people")
@EqualsAndHashCode(exclude = "people")
@Builder
@Table
@Entity
public class Passport {

    @GenericGenerator(name = "one-one",
                    strategy = "foreign",
                    parameters = @Parameter(name = "property",
                    value = "people"))
    @GeneratedValue(generator = "one-one")
    @Id
    @Column(name = "id_people")
    private int idPeople;

    @Column
    private String serial;

    @Column
    private Integer number;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private People people;
}
