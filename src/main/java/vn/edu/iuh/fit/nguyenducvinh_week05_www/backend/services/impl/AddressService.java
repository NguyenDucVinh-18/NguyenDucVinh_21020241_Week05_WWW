package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.IServices;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IServices<Address, Long> {

    @Autowired
    private AddressRepository ar;


    @Override
    public Address add(Address address) {
        return ar.save(address);
    }

    @Override
    public Address update(Address address) {
        return ar.save(address);
    }

    @Override
    public void delete(Long aLong) throws EntityIdNotFoundException{
        ar.delete(getById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public Optional<Address> getById(Long aLong) throws EntityIdNotFoundException{
        return Optional.of(ar.findById(aLong).orElseThrow(() -> new EntityIdNotFoundException(aLong + "")));
    }

    @Override
    public List<Address> getAll() {
        return ar.findAll();
    }
}
