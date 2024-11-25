package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillType;

@Getter
@Setter
@Entity
@Table(name = "skill", schema = "works")
public class Skill {
    @Id
    @Column(name = "skill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private SkillType type;

}