package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}