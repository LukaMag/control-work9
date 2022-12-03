package controlwork9.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "work_logs")
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "spent_time")
    private String spentTime;

    @Column(name = "datetime_started")
    private LocalDateTime dateTimeStarted;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
