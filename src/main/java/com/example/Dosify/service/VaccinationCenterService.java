package com.example.Dosify.service;

import com.example.Dosify.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;

public interface VaccinationCenterService {

    public VaccinationCenterResponseDto addCenter(VaccinationCenterRequestDto vaccinationCenterRequestDto);
}
