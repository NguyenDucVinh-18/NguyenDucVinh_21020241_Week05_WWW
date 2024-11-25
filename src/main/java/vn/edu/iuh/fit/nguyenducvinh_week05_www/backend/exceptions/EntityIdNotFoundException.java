package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions;

public class EntityIdNotFoundException extends RuntimeException {
    public EntityIdNotFoundException(String id) {

        super("The entity with id " + id + " was not found.");
    }
}
