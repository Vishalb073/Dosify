package com.example.Dosify.transformer;

import com.example.Dosify.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.VaccinationCenterRepository;

public class VaccinationCenterTransformer {

    public static VaccinationCenter ResponseDtoToCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto){

        return VaccinationCenter.builder()
                .name(vaccinationCenterRequestDto.getName())
                .centerType(vaccinationCenterRequestDto.getCenterType())
                .location(vaccinationCenterRequestDto.getLocation())
                .build();
    }

    public static VaccinationCenterResponseDto EntityToCenter(VaccinationCenter vaccinationCenter){

        return VaccinationCenterResponseDto.builder()
                .name(vaccinationCenter.getName())
                .centerType(vaccinationCenter.getCenterType())
                .location(vaccinationCenter.getLocation())
                .build();
    }
}
