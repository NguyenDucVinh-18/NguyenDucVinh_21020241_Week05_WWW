package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Company;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements IServices<Company, Long> {


    @Autowired
    private CompanyRepository cr;

    @Override
    public Company add(Company company) {
        return cr.save(company);
    }

    @Override
    public List<Company> addMany(List<Company> list) {
        List<Company> results = new ArrayList<>();
        Iterator<Company> output = cr.saveAll(list).iterator();
        output.forEachRemaining(results::add);
        return results;
    }

    @Override
    public Company update(Company company) {
        return cr.save(company);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException {
        cr.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Company> getById(Long aLong) throws EntityIdNotFoundException {
        return Optional.of(cr.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Company> getAll() {
        return cr.findAll();
    }

    public Company checkLogin(String email, String password){
        return cr.findByEmailAndPassword(email,password).orElse(null);
    }

}
