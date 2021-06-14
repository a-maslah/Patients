package com.example.demo.Repository;

import com.example.demo.entites.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContains(String mc, Pageable pageable);

}
