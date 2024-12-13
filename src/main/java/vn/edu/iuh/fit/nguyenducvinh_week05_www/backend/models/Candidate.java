package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.CandidateRole;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "candidate", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class Candidate {
    @Id
    @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dob", nullable = false)
    @NonNull
    private LocalDate dob;

    @Column(name = "email", nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "full_name", nullable = false)
    @NonNull
    private String fullName;

    @Column(name = "phone", nullable = false, length = 15)
    @NonNull
    private String phone;

    @Column(nullable = false, length = 100)
    @NonNull
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address", nullable = false)
    @NonNull
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidateRole role;

    @Column(nullable = false)
    private boolean status;

    @PrePersist
    public void prePersist() {
        status = true;
        role = CandidateRole.USER;
    }
}