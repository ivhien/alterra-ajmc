package com.arifin.project.alterra.ajmc.assignment.Tugas02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
}
