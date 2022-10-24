package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.common.ResponseUtil;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.constant.MessageConstant;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.City;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.CityForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.CityRepository;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.CountryRepository;

@Service
public class CitySvcImpl implements CitySvc{
    private final CityRepository cityRepository;
    
    @Autowired
    public CitySvcImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public ResponseEntity<Object> create(CityForm form) {
        try {
            City city = new City();
            city.setCode(form.getCode());
            city.setName(form.getName());
            city.setCountrycode(form.getCountrycode());

            cityRepository.save(city);
            return ResponseUtil.build(MessageConstant.SUCCESS, city, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAll() {
        try {
            List<City> cities = cityRepository.findAll();
            return ResponseUtil.build(MessageConstant.SUCCESS, cities, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(String code) {
        try {
            Optional<City> getById = cityRepository.findById(code);
            return getById.map(City -> ResponseUtil.build(MessageConstant.SUCCESS, City, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(CityForm form, String code) {
        try {
            Optional<City> getById = cityRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            City city = getById.get();
            city.setName(form.getName());
            city.setCountrycode(form.getCountrycode());
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, cityRepository.save(city), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(String code) {
        try {
            Optional<City> getById = cityRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            cityRepository.deleteById(code);
            
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
