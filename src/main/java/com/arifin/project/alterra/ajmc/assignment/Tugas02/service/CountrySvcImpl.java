package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.common.ResponseUtil;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.constant.MessageConstant;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Country;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CountryForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.CountryRepository;

@Service
public class CountrySvcImpl implements CountrySvc {
    private final CountryRepository countryRepository;

    @Autowired
    public CountrySvcImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public ResponseEntity<Object> create(CountryForm form) {
        try {
            Country country = new Country();
            country.setCode(form.getCode());
            country.setName(form.getName());

            countryRepository.save(country);

            return ResponseUtil.build(MessageConstant.SUCCESS, country, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAll() {
        try {
            List<Country> countries = countryRepository.findAll();
            return ResponseUtil.build(MessageConstant.SUCCESS, countries, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(String code) {
        try {
            Optional<Country> getById = countryRepository.findById(code);
            return getById.map(Country -> ResponseUtil.build(MessageConstant.SUCCESS, Country, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(CountryForm form, String code) {
        try {
            Optional<Country> getById = countryRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            Country country = getById.get();
            country.setName(form.getName());
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, countryRepository.save(country), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(String code) {
        try {
            Optional<Country> getById = countryRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            countryRepository.deleteById(code);
            
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
