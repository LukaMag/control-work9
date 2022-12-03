package controlwork9.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column
    private String status;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private User user;

    @PrePersist
    public void setDate(){
        dateCreated = LocalDate.now();
    }
}
