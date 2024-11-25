package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;

public interface IManagement <T,P>{
    ResponseEntity<Response> insert(T t);
    ResponseEntity<Response> update(P p,T t);
    ResponseEntity<Response> delete(P p);
    ResponseEntity<Response> findById(P p);
    ResponseEntity<Response> findAll();

}
