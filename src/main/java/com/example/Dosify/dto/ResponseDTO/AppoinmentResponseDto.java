package com.example.Dosify.dto.ResponseDTO;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccinationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppoinmentResponseDto {


    String userName;

    String appointmentNo;

    Date dateOfAppointment;

    DoseNo doseNo;

    VaccinationCenterResponseDto centerResponseDto;

    String doctorName;

    VaccinationType vaccineType;

}
