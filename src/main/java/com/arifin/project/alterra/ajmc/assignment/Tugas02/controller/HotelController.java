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

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.HotelForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.service.HotelSvc;

@RestController
@RequestMapping("/v1/hotel")
public class HotelController {
    private final HotelSvc hotelSvc;

    @Autowired
    public HotelController(HotelSvc hotelSvc) {
        this.hotelSvc = hotelSvc;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody HotelForm form){
        return hotelSvc.create(form);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        return hotelSvc.getAll();
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<Object> getById(@PathVariable  String code){
        return hotelSvc.findById(code);
    }

    // @PostMapping(value = "{code}")
    @PutMapping("{code}")
    public ResponseEntity<Object> update(@RequestBody HotelForm form, @PathVariable String code){
        return hotelSvc.updateById(form, code);
    }

    @DeleteMapping(value = "{code}")
    public ResponseEntity<Object> deleteById(@PathVariable String code){
        return hotelSvc.deleteById(code);
    }
}