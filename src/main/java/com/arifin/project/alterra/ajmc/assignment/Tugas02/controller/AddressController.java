package com.arifin.project.alterra.ajmc.assignment.Tugas02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.AddressForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.service.AddressSvc;

@RestController
@RequestMapping("/v1/address")
public class AddressController {
    private final AddressSvc addressSvc;

    @Autowired
    public AddressController(AddressSvc addressSvc) {
        this.addressSvc = addressSvc;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody AddressForm form){
        return addressSvc.create(form);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return addressSvc.getAll();
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<Object> getById(@PathVariable Integer code){
        return addressSvc.findById(code);
    }

    // @PostMapping(value = "{code}")
    @PutMapping("{code}")
    public ResponseEntity<Object> update(@RequestBody AddressForm form, @PathVariable Integer code){
        return addressSvc.updateById(form, code);
    }

    @DeleteMapping(value = "{code}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer code){
        return addressSvc.deleteById(code);
    }
}