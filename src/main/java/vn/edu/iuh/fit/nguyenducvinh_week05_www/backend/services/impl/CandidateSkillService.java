package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService implements IServices<CandidateSkill, CandidateSkillId> {

    @Autowired
    private CandidateSkillRepository csr;

    @Override
    public CandidateSkill add(CandidateSkill candidateSkill) {
        return csr.save(candidateSkill);
    }

    @Override
    public CandidateSkill update(CandidateSkill candidateSkill) {
        return csr.save(candidateSkill);
    }

    @Override
    public void delete(CandidateSkillId candidateSkillId) throws EntityIdNotFoundException {
        csr.delete(getById(candidateSkillId).orElseThrow(() -> new EntityIdNotFoundException("Skill ID: " + candidateSkillId.getSkillId() + " Candidate ID: " + candidateSkillId.getCanId())));
    }

    @Override
    public Optional<CandidateSkill> getById(CandidateSkillId candidateSkillId) throws EntityIdNotFoundException {
        return Optional.of(csr.findById(candidateSkillId).orElseThrow(() -> new EntityIdNotFoundException("Skill ID: " + candidateSkillId.getSkillId() + " Candidate ID: " + candidateSkillId.getCanId())));
    }


    @Override
    public List<CandidateSkill> getAll() {
        return csr.findAll();
    }
}
