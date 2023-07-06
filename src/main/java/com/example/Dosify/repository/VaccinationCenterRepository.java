package com.example.Dosify.repository;

import com.example.Dosify.model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {
}
