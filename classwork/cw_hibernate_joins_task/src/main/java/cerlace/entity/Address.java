package cerlace.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "apartments")
@EqualsAndHashCode(exclude = "apartments")
@Builder
@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String street;

    @Column
    private Integer house;

    @OneToMany(mappedBy = "address")
    private Set<Apartment> apartments = new HashSet();
}
