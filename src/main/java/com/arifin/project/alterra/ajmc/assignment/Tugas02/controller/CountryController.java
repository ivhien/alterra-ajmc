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

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CountryForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.service.CountrySvc;

@RestController
@RequestMapping("/v1/country")
public class CountryController {
    private final CountrySvc countrySvc;

    @Autowired
    public CountryController(CountrySvc countrySvc) {
        this.countrySvc = countrySvc;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CountryForm form){
        return countrySvc.create(form);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return countrySvc.getAll();
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<Object> getById(@PathVariable  String code){
        return countrySvc.findById(code);
    }

    // @PostMapping(value = "{code}")
    @PutMapping("{code}")
    public ResponseEntity<Object> update(@RequestBody CountryForm form, @PathVariable String code){
        return countrySvc.updateById(form, code);
    }

    @DeleteMapping(value = "{code}")
    public ResponseEntity<Object> deleteById(@PathVariable String code){
        return countrySvc.deleteById(code);
    }
    
}
