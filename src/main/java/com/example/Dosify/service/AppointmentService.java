package com.example.Dosify.service;

import com.example.Dosify.dto.RequestDTO.AppoinmentRequestDto;
import com.example.Dosify.dto.ResponseDTO.AppoinmentResponseDto;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.exception.UserTakesDoseException;

public interface AppointmentService {

    public AppoinmentResponseDto bookAppointment(AppoinmentRequestDto appoinmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, UserTakesDoseException;
}
