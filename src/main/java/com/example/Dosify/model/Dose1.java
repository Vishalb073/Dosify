package com.example.Dosify.model;

import com.example.Dosify.Enum.Gender;
import com.example.Dosify.Enum.VaccinationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String doseId;

    @Enumerated(EnumType.STRING)
    VaccinationType type;

    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;

}
