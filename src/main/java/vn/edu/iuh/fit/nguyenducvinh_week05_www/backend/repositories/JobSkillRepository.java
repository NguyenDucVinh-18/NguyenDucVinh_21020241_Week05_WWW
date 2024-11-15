package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
}