package cerlace.example.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
