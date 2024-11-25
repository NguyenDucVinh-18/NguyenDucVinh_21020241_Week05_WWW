package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Candidate;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements IServices<Candidate, Long> {

    @Autowired
    private CandidateRepository cr;

    @Override
    public Candidate add(Candidate candidate) {
        return cr.save(candidate);
    }

    @Override
    public Candidate update(Candidate candidate) {
        return cr.save(candidate);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        cr.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Candidate> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(cr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Candidate> getAll() {
        return cr.findAll();
    }
}
