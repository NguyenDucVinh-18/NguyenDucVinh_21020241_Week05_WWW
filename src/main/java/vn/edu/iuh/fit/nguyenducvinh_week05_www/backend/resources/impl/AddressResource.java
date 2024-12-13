package vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.exceptions.EntityIdNotFoundException;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Address;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.models.Response;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.resources.IManagement;
import vn.edu.iuh.fit.nguyenducvinh_week05_www.backend.services.impl.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address")
@Slf4j
public class AddressResource implements IManagement<Address, Long> {

    @Autowired
    private AddressService as;

    @PostMapping
    @Override
    public ResponseEntity<Response> insert(@RequestBody Address address) {
        log.info("Call address insert");
        try{
            Address output = as.add(address);
            log.info("Insert address success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert address success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert address fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert address fail",
                    null
            ));
        }
    }

    @PostMapping("/list")
    @Override
    public ResponseEntity<Response> insertAll(@RequestBody List<Address> t) {
        log.info("Call list address insert");
        try{
            List<Address> output = as.addMany(t);
            log.info("Insert list address success");
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list address success",
                    output
            ));
        } catch (Exception e) {
            log.error("Insert list address fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.OK.value(),
                    "Insert list address fail",
                    null
            ));
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@PathVariable("id") Long aLong,@RequestBody Address address) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long aLong) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> findById(@PathVariable("id") Long aLong) {
        log.info("Calling get address by id " + aLong);
        try{
            Optional<Address> address = as.getById(aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NO_CONTENT.value(),
                    "Get address by id " + aLong + " success",
                    address.get()
            ));
        } catch (EntityIdNotFoundException e) {
            log.warn("Not found address by id " + aLong);
            return ResponseEntity.ok(new Response(
                    HttpStatus.NOT_FOUND.value(),
                    "Not found address by id " + aLong,
                    null
            ));
        } catch (Throwable e) {
            log.warn("Address by id " + aLong + " fail");
            log.error("Error: " + e);
            return ResponseEntity.ok(new Response(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Address by id " + aLong + " fail",
                    null
            ));
        }
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> findAll() {
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all address success",
                as.getAll()
        ));
    }
}
