package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Skill;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.SkillRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements IServices<Skill, Long> {

    @Autowired
    private SkillRepository sr;

    @Override
    public Skill add(Skill skill) {
        return sr.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return sr.save(skill);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        sr.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Skill> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(sr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Skill> getAll() {
        return sr.findAll();
    }
}
