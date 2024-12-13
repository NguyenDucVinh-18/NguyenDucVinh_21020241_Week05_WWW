package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CandidateSkillId implements Serializable {
    private static final long serialVersionUID = 7959505589146447260L;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    public CandidateSkillId(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    public CandidateSkillId() {
    }
}