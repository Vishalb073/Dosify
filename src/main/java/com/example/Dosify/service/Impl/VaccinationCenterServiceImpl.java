package com.example.Dosify.service.Impl;

import com.example.Dosify.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.VaccinationCenterRepository;
import com.example.Dosify.service.VaccinationCenterService;
import com.example.Dosify.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Override
    public VaccinationCenterResponseDto addCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto) {

        // Request dto to entity
        VaccinationCenter center = VaccinationCenterTransformer.ResponseDtoToCenter(vaccinationCenterRequestDto);

        // save entity in database
        vaccinationCenterRepository.save(center);

        // entity to response dto

        return VaccinationCenterTransformer.EntityToCenter(center);


    }
}
