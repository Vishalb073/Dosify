package com.example.Dosify.model;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Appoinment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String appoinmentNo;

    @CreationTimestamp
    Date dateOfAppoinment;

    @Enumerated(EnumType.STRING)
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

}
