package com.example.Dosify.dto.RequestDTO;


import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccinationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppoinmentRequestDto {

    DoseNo doseNo;

    int userId;

    int docterId;

    VaccinationType vaccinationType;
}
