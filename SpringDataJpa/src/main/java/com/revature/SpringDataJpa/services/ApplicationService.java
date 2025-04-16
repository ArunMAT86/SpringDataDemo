package com.revature.SpringDataJpa.services;


import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Application;
import com.revature.SpringDataJpa.repositories.ApplicantRepository;
import com.revature.SpringDataJpa.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    ApplicationRepository applicationRepository;
    ApplicantRepository applicantRepository;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
    }

    public Application saveApplication(Integer applicant_id, Application application){
        Optional<Applicant> applicantOptional = applicantRepository.findById(applicant_id);
        if(applicantOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            application.setApplicant(applicant);
            return this.applicationRepository.save(application);
        }else {

            throw new RuntimeException("Applicant is not present " + applicant_id);
        }




    }
}
