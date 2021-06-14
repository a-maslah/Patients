package com.example.demo;

import com.example.demo.Repository.ConsultationRepository;
import com.example.demo.Repository.MedecinRepository;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.Repository.RendezVousRepository;
import com.example.demo.entites.Consultation;
import com.example.demo.entites.Medecin;
import com.example.demo.entites.Patient;
import com.example.demo.entites.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(null,"amine","maslah",new Date()));
        patientRepository.save(new Patient(null,"mohamed","khalid",new Date()));
        patientRepository.save(new Patient(null,"ayoub","yassine",new Date()));


    }
}
