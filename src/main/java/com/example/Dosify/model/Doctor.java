package com.example.Dosify.model;


import com.example.Dosify.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "contact_no")
    String contactNo;

    @Column(name = "email_id")
    String emailId;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appoinment> appoinments = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter vaccinationCenter;
}
