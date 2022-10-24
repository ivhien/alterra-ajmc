package com.arifin.project.alterra.ajmc.assignment.Tugas02.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arifin.project.alterra.ajmc.assignment.Tugas02.entity.Logging;
import com.arifin.project.alterra.ajmc.assignment.Tugas02.repository.LoggingRepository;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class LoggingSvcImpl implements LoggingSvc {

    @Autowired
    private LoggingRepository loggingRepository;

    @Override
    public void createLog(HashMap<String, Object> data, String type) {
        try {
            Logging log = new Logging();
            log.setId(UUID.randomUUID().toString());
            log.setData(data);
            log.setType(type);
            loggingRepository.save(log);
        } catch (Exception e) {
            log.error("error logging mongo {}", e.getMessage());
        }
    }
}