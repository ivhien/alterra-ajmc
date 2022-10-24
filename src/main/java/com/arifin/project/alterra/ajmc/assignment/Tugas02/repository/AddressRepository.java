package com.arifin.project.alterra.ajmc.assignment.Tugas02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByHotelcode(String hotelcode);
}
