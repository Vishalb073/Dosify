package com.example.Dosify.service.Impl;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.dto.RequestDTO.AppoinmentRequestDto;
import com.example.Dosify.dto.ResponseDTO.AppoinmentResponseDto;
import com.example.Dosify.dto.ResponseDTO.VaccinationCenterResponseDto;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.exception.UserTakesDoseException;
import com.example.Dosify.model.*;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.AppointmentService;
import com.example.Dosify.service.Dose1Service;
import com.example.Dosify.service.Dose2Service;
import com.example.Dosify.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired Dose1Service dose1Service;

    @Autowired
    Dose2Service dose2Service;

    @Override
    public AppoinmentResponseDto bookAppointment(AppoinmentRequestDto appoinmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, UserTakesDoseException {

       Optional<User> optionalUser =  userRepository.findById(appoinmentRequestDto.getUserId());

       if(!optionalUser.isPresent()){

           throw new UserNotFoundException("User does'nt exit");
       }

       Optional<Doctor> optionalDoctor = doctorRepository.findById(appoinmentRequestDto.getDocterId());

       if(!optionalDoctor.isPresent()){
           throw new DoctorNotFoundException("Doctor does'nt exit");
       }

       User user = optionalUser.get();

       Doctor doctor = optionalDoctor.get();

       if(appoinmentRequestDto.getDoseNo() == DoseNo.DOSE_NO_1){
            Dose1 dose1 = dose1Service.createDose1(user, appoinmentRequestDto.getVaccinationType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
       }
       else{
           // for dose2

           if(!user.isDose1Taken()){
               throw new UserTakesDoseException("You are not Eligible as dose 1 is not taken");
           }
           Dose2 dose2 = dose2Service.createDose2(user, appoinmentRequestDto.getVaccinationType());
           user.setDose2Taken(true);
           user.setDose2(dose2);
       }

        VaccinationCenterResponseDto vaccinationCenterResponseDto = VaccinationCenterTransformer.EntityToCenter(doctor.getVaccinationCenter());
        Appoinment appoinment = Appoinment.builder()
                .appoinmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appoinmentRequestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();
       user.getAppoinments().add(appoinment);
       User savedUser = userRepository.save(user);

       Appoinment savedAppointment = savedUser.getAppoinments().get(savedUser.getAppoinments().size()-1);
       doctor.getAppoinments().add(savedAppointment);
       doctorRepository.save(doctor);

        VaccinationCenterResponseDto centerResponseDto = VaccinationCenterTransformer.EntityToCenter(doctor.getVaccinationCenter());

        return AppoinmentResponseDto.builder()
                .userName(user.getName())
                .appointmentNo(appoinment.getAppoinmentNo())
                .dateOfAppointment(savedAppointment.getDateOfAppoinment())
                .doseNo(appoinment.getDoseNo())
                .centerResponseDto(centerResponseDto)
                .doctorName(doctor.getName())
                .vaccineType(appoinmentRequestDto.getVaccinationType())
                .build();
      }
}
