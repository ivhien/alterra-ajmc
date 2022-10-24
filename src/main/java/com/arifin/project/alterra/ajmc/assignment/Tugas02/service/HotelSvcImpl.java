package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.common.ResponseUtil;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.constant.MessageConstant;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Hotel;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.HotelForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.HotelRepository;

@Service
public class HotelSvcImpl implements HotelSvc{
    private final HotelRepository hotelRepository;
    
    @Autowired
    public HotelSvcImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public ResponseEntity<Object> create(HotelForm form) {
        try {
            Hotel hotel = new Hotel();
            hotel.setCode(form.getCode());
            hotel.setName(form.getName());
            hotel.setCitycode(form.getCitycode());
            hotel.setRating(form.getRating());
            hotel.setWebsite(form.getWebsite());

            hotelRepository.save(hotel);
            return ResponseUtil.build(MessageConstant.SUCCESS, hotel, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAll() {
        try {
            List<Hotel> hotels = hotelRepository.findAll();
            return ResponseUtil.build(MessageConstant.SUCCESS, hotels, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(String code) {
        try {
            Optional<Hotel> getById = hotelRepository.findById(code);
            return getById.map(Hotel -> ResponseUtil.build(MessageConstant.SUCCESS, Hotel, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(HotelForm form, String code) {
        try {
            Optional<Hotel> getById = hotelRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            Hotel hotel = getById.get();
            hotel.setName(form.getName());
            hotel.setCitycode(form.getCitycode());
            hotel.setRating(form.getRating());
            hotel.setWebsite(form.getWebsite());

            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, hotelRepository.save(hotel), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(String code) {
        try {
            Optional<Hotel> getById = hotelRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            hotelRepository.deleteById(code);
            
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
