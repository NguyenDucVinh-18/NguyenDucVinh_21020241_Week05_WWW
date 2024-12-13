package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class JobSkillId implements Serializable {
    private static final long serialVersionUID = 2323802082645217969L;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;


    public JobSkillId(Job job, Skill skill) {
        this.job = job;
        this.skill = skill;
    }

    public JobSkillId() {
    }


}