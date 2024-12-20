package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Job;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.JobRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<Job> addMany(List<Job> list) {
        List<Job> results = new ArrayList<>();
        Iterator<Job> output = jr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
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

    public List<Job> getByCompanyId(Long id){
        return jr.findByCompany_Id(id);
    }
}
