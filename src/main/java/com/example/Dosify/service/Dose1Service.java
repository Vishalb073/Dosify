package com.example.Dosify.service;

import com.example.Dosify.Enum.VaccinationType;
import com.example.Dosify.model.Dose1;
import com.example.Dosify.model.User;

public interface Dose1Service {

    public Dose1 createDose1(User user, VaccinationType vaccinationType);
}
