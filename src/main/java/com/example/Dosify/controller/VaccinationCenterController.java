package com.example.Dosify.controller;

import com.example.Dosify.dto.RequestDTO.VaccinationCenterRequestDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.Dosify.repository.VaccinationCenterRepository;
import com.example.Dosify.service.Impl.VaccinationCenterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterServiceImpl vaccinationCenterService;
    @PostMapping("/add-center")
    public ResponseEntity addCenter(@RequestBody VaccinationCenterRequestDto vacinationCenterRequestDto){

        VaccinationCenterResponseDto response = vaccinationCenterService.addCenter(vacinationCenterRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // give the list of all doctors at a particular center(Centerid)

    // give the list of all male doctors at a particular center

    // give the list of all male doctors who's age is above 40;

    // give all centeres which has particular center type


}
