package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;

@Getter
@Setter
@Entity
@Table(name = "job_skill", schema = "works")
@NoArgsConstructor
@RequiredArgsConstructor
public class JobSkill {
    @EmbeddedId @NonNull
    private JobSkillId id;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false) @NonNull
    private SkillLevel skillLevel;

    public JobSkill(@NonNull JobSkillId id, String moreInfos, @NonNull SkillLevel skillLevel) {
        this.id = id;
        this.moreInfos = moreInfos;
        this.skillLevel = skillLevel;
    }

    public @NonNull JobSkillId getId() {
        return id;
    }

    public void setId(@NonNull JobSkillId id) {
        this.id = id;
    }

    public String getMoreInfos() {
        return moreInfos;
    }

    public void setMoreInfos(String moreInfos) {
        this.moreInfos = moreInfos;
    }

    public @NonNull SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(@NonNull SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }
}