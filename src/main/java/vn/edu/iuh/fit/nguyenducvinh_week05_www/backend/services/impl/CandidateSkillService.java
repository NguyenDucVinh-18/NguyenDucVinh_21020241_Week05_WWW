package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.CandidateSkill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<CandidateSkill> addMany(List<CandidateSkill> list) {
        List<CandidateSkill> results = new ArrayList<>();
        Iterator<CandidateSkill> output = csr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public CandidateSkill update(CandidateSkill candidateSkill) {
        return csr.save(candidateSkill);
    }

    @Override
    public void delete(CandidateSkillId id) throws EntityIdNotFoundException {
        csr.delete(getById(id).orElseThrow(() -> new EntityIdNotFoundException("skillId: " + id.getCandidate() + ", candidateId: " + id.getCandidate())));
    }

    @Override
    public Optional<CandidateSkill> getById(CandidateSkillId id) throws EntityIdNotFoundException {
        return Optional.of(csr.findById(id).orElseThrow(() -> new EntityIdNotFoundException("skillId: " + id.getSkill() + ", candidateId: " + id.getSkill())));
    }


    @Override
    public List<CandidateSkill> getAll() {
        return csr.findAll();
    }

    public List<CandidateSkill> getAllSkillByCanId(Long canId) {
        return csr.findById_Candidate_Id(canId);
    }
}
