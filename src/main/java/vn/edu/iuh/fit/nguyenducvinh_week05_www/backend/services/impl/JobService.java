package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.JobRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IServices<Job, Long> {

    @Autowired
    private JobRepository jr;

    @Override
    public Job add(Job job) {
        return jr.save(job);
    }

    @Override
    public Job update(Job job) {
        return jr.save(job);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        jr.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Job> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(jr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Job> getAll() {
        return jr.findAll();
    }
}
