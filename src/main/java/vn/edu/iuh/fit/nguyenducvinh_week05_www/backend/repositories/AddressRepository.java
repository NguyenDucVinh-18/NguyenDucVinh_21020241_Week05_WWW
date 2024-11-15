package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}