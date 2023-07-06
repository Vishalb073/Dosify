package com.example.Dosify.service.Impl;

import com.example.Dosify.Enum.VaccinationType;
import com.example.Dosify.model.Dose2;
import com.example.Dosify.model.User;
import com.example.Dosify.service.Dose2Service;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dose2ServiceImpl implements Dose2Service {
    @Override
    public Dose2 createDose2(User user, VaccinationType vaccinationType) {

        return Dose2.builder()
                .doseId(String.valueOf(UUID.randomUUID()))
                .type(vaccinationType)
                .user(user)
                .build();
    }
}
