package com.arifin.project.alterra.ajmc.assignment.Tugas02.repository;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Logging;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingRepository extends MongoRepository<Logging, String> {
}

