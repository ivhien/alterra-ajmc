package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.common.ResponseUtil;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.constant.MessageConstant;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Address;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.form.AddressForm;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.AddressRepository;

@Service
public class AddressSvcImpl implements AddressSvc {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressSvcImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public ResponseEntity<Object> create(AddressForm form) {
        try {
            Address address = new Address();
            address.setAddress(form.getAddress());
            address.setHotelcode(form.getHotelcode());
            address.setZipCode(form.getZipcode());

            addressRepository.save(address);
            return ResponseUtil.build(MessageConstant.SUCCESS, address, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> getAll() {
        try {
            List<Address> address = addressRepository.findAll();
            return ResponseUtil.build(MessageConstant.SUCCESS, address, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(Integer code) {
        try {
            Optional<Address> getById = addressRepository.findById(code);
            return getById.map(Address -> ResponseUtil.build(MessageConstant.SUCCESS, Address, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(AddressForm form, Integer code) {
        try {
            Optional<Address> getById = addressRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            Address address = getById.get();
            address.setAddress(form.getAddress());
            address.setHotelcode(form.getHotelcode());
            address.setZipCode(form.getZipcode());
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, addressRepository.save(address), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Integer code) {
        try {
            Optional<Address> getById = addressRepository.findById(code);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            addressRepository.deleteById(code);
            
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findByHotelcode(String hotelcode) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
