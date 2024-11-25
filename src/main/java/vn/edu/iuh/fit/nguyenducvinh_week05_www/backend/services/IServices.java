package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services;

import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IServices<T, P> {
    T add(T t);
    T update(T t);
    void delete(P p) throws EntityIdNotFoundException;
    Optional<T> getById(P p) throws EntityIdNotFoundException;
    List<T> getAll();
}
