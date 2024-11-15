package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Setter @Getter
@NoArgsConstructor
public class Experience {
    @Id @Column(name = "exp_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expId;
    @Column(name = "company", length = 120, nullable = false)
    private String companyName;
    @Column(name = "work_desc", length = 400)
    private String workDescription;
    @Column(name = "role", length = 100, nullable = false)
    private String role;
    @Column(name = "from_date",  nullable = false)
    private LocalDate fromDate;
    @Column(name = "to_date",  nullable = false)
    private LocalDate toDate;
    @ManyToOne @JoinColumn(name = "can_id",  nullable = false)
    private Candidate candidate;
}
