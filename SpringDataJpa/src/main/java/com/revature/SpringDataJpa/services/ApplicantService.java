package com.revature.SpringDataJpa.services;

import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.repositories.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant createApplicant(Applicant applicant){
        return this.applicantRepository.save(applicant);
    }


    public List<Applicant> getAllApplicant(){
        return this.applicantRepository.findAll();
    }
}
