package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.JobSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.JobSkillRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService implements IServices<JobSkill, JobSkillId> {

    @Autowired
    private JobSkillRepository jsr;

    @Override
    public JobSkill add(JobSkill jobSkill) {
        return jsr.save(jobSkill);
    }

    @Override
    public JobSkill update(JobSkill jobSkill) {
        return jsr.save(jobSkill);
    }

    @Override
    public void delete(JobSkillId jobSkillId) throws EntityIdNotFoundException {
        jsr.delete(getById(jobSkillId).orElseThrow(() -> new EntityIdNotFoundException("Job ID: " + jobSkillId.getJobId() + " Skill ID: " + jobSkillId.getSkillId())));
    }

    @Override
    public Optional<JobSkill> getById(JobSkillId jobSkillId) throws EntityIdNotFoundException {
        return Optional.of(jsr.findById(jobSkillId).orElseThrow(() -> new EntityIdNotFoundException("Job ID: " + jobSkillId.getJobId() + " Skill ID: " + jobSkillId.getSkillId())));
    }


    @Override
    public List<JobSkill> getAll() {
        return jsr.findAll();
    }
}
