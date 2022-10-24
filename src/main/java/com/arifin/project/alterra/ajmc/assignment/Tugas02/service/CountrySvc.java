package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import org.springframework.http.ResponseEntity;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CountryForm;

public interface CountrySvc {
    ResponseEntity<Object> create(CountryForm form);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> findById(String code);
    ResponseEntity<Object> updateById(CountryForm form, String code);
    ResponseEntity<Object> deleteById(String code);
}
