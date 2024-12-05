package cerlace.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "meeting_date")
    private Date meetingDate;

    @Column
    private String subject;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet();
}
