package com.example.Dosify.service.Impl;

import com.example.Dosify.dto.RequestDTO.DoctorRequestDto;
import com.example.Dosify.dto.ResponseDTO.DoctorResponseDto;
import com.example.Dosify.exception.CenterNotPresentException;
import com.example.Dosify.model.Doctor;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.repository.VaccinationCenterRepository;
import com.example.Dosify.service.DoctorService;
import com.example.Dosify.transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;



    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    @Override
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException {

        Optional<VaccinationCenter> optionlCenter = vaccinationCenterRepository.findById(doctorRequestDto.getCenterId());

        if(!optionlCenter.isPresent()){

            throw new CenterNotPresentException("Invalid Center id");

        }

        VaccinationCenter center = optionlCenter.get();
        // request dto to Entity


        Doctor doctor = DoctorTransformer.doctorRequestDtoToDoctor(doctorRequestDto);

        doctor.setVaccinationCenter(center);

        // add doctor to current list of doctors at that center
        center.getDoctors().add(doctor);

        VaccinationCenter vaccinationCenter = vaccinationCenterRepository.save(center); // saves both center and doctor

        return DoctorTransformer.entityToDoctorResponseDTo(doctor);
    }
}
