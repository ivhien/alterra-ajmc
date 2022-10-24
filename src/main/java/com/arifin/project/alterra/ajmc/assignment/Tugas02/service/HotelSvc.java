package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import org.springframework.http.ResponseEntity;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.HotelForm;

public interface HotelSvc {
    ResponseEntity<Object> create(HotelForm form);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> findById(String code);
    ResponseEntity<Object> updateById(HotelForm form, String code);
    ResponseEntity<Object> deleteById(String code);
    
}
