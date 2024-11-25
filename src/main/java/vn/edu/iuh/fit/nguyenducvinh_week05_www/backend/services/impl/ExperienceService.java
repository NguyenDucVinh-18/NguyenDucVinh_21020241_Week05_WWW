package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Experience;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.ExperienceRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IServices<Experience, Long> {

    @Autowired
    private ExperienceRepository er;



    @Override
    public Experience add(Experience experience) {
        return er.save(experience);
    }

    @Override
    public Experience update(Experience experience) {
        return er.save(experience);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        er.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Experience> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(er.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Experience> getAll() {
        return er.findAll();
    }


}
