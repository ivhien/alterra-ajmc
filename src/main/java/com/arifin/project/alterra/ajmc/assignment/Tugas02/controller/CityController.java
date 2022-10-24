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

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CityForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.service.CitySvc;

@RestController
@RequestMapping("/v1/city")
public class CityController {
    private final CitySvc citySvc;

    @Autowired
    public CityController(CitySvc citySvc) {
        this.citySvc = citySvc;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CityForm form){
        return citySvc.create(form);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return citySvc.getAll();
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<Object> getById(@PathVariable  String code){
        return citySvc.findById(code);
    }

    // @PostMapping(value = "{code}")
    @PutMapping("{code}")
    public ResponseEntity<Object> update(@RequestBody CityForm form, @PathVariable String code){
        return citySvc.updateById(form, code);
    }

    @DeleteMapping(value = "{code}")
    public ResponseEntity<Object> deleteById(@PathVariable String code){
        return citySvc.deleteById(code);
    }
    
}
