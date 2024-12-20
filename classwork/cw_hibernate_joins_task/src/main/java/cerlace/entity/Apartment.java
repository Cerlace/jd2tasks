package cerlace.entity;

import lombok.*;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "peoples")
@EqualsAndHashCode(exclude = "peoples")
@Builder
@Table
@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Integer floor;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "apartments")
    private Set<People> peoples = new HashSet();
}
