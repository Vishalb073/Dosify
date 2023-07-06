package com.example.Dosify.controller;

import com.example.Dosify.dto.RequestDTO.AppoinmentRequestDto;
import com.example.Dosify.dto.ResponseDTO.AppoinmentResponseDto;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.exception.UserTakesDoseException;
import com.example.Dosify.service.AppointmentService;
import com.example.Dosify.service.Impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

    @Autowired
    AppointmentServiceImpl appointmentService;
    @PostMapping("/book")
    public AppoinmentResponseDto bookAppoinment(@RequestBody AppoinmentRequestDto appoinmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, UserTakesDoseException {

        return appointmentService.bookAppointment(appoinmentRequestDto);
    }

    // generate certificate
        // -> One dose
        // -> both dose
}
