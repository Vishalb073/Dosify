package com.example.Dosify.service.Impl;

import com.example.Dosify.Enum.VaccinationType;
import com.example.Dosify.model.Dose1;
import com.example.Dosify.model.User;
import com.example.Dosify.service.Dose1Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose1ServiceImpl implements Dose1Service {

    @Override
    public Dose1 createDose1(User user, VaccinationType vaccinationType) {
        return Dose1.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .type(vaccinationType)
                .user(user)
                .build();
    }
}
