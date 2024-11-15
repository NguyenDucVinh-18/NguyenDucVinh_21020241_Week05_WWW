package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}