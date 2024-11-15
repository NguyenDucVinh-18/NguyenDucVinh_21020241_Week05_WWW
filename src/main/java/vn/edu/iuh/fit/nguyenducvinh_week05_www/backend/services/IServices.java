package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services;

import java.util.List;
import java.util.Optional;

public interface IServices<T, P> {
    T add(T t);
    T update(T t);
    T delete(P p);
    Optional<T> getById(P p);
    List<T> getAll();
}
