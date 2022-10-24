package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import org.springframework.http.ResponseEntity;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CityForm;

public interface CitySvc {
    ResponseEntity<Object> create(CityForm form);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> findById(String code);
    ResponseEntity<Object> updateById(CityForm form, String code);
    ResponseEntity<Object> deleteById(String code);
    
}
