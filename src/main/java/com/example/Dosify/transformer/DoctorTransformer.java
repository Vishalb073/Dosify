package com.example.Dosify.transformer;


import com.example.Dosify.dto.RequestDTO.DoctorRequestDto;
import com.example.Dosify.dto.ResponseDTO.DoctorResponseDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.Dosify.model.Doctor;

import javax.print.Doc;

public class DoctorTransformer {

    public static Doctor doctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto){

        return Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .emailId(doctorRequestDto.getEmailId())
                .contactNo(doctorRequestDto.getContactNo())
                .gender(doctorRequestDto.getGender())
                .build();
    }

    public static DoctorResponseDto entityToDoctorResponseDTo(Doctor doctor){


        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.EntityToCenter(doctor.getVaccinationCenter());
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .contactNo(doctor.getContactNo())
                .emailId(doctor.getEmailId())
                .vaccinationCenterResponseDto(vaccinationCenterResponseDto)
                .build();
    }
}
