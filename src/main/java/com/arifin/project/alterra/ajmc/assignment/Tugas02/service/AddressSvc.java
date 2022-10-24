package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import org.springframework.http.ResponseEntity;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.AddressForm;

public interface AddressSvc {
    ResponseEntity<Object> create(AddressForm form);
    ResponseEntity<Object> getAll();
    ResponseEntity<Object> findById(Integer id);
    ResponseEntity<Object> findByHotelcode(String hotelcode);
    ResponseEntity<Object> updateById(AddressForm form, Integer id);
    ResponseEntity<Object> deleteById(Integer id);
}
