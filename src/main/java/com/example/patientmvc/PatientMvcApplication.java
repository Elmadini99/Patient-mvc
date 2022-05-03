package com.example.patientmvc;

import com.example.patientmvc.entities.Patient;
import com.example.patientmvc.repositories.PatientRepository;
import com.example.patientmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {

        SpringApplication.run(PatientMvcApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null,"Hassan",new Date(),false,120));
            patientRepository.save(
                    new Patient(null,"Mohammed",new Date(),true,101));
            patientRepository.save(
                    new Patient(null,"Youssef",new Date(),true,500));
            patientRepository.save(
                    new Patient(null,"Ahmed",new Date(),false,320));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            } );

        } ;

    }
   //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("Yassin","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("yassine","USER");
            securityService.addRoleToUser("hassan","ADMIN");


        };

    }
}