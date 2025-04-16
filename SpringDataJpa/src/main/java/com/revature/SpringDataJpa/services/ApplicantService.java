package com.revature.SpringDataJpa.services;

import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Application;
import com.revature.SpringDataJpa.entities.Resume;
import com.revature.SpringDataJpa.repositories.ApplicantRepository;
import com.revature.SpringDataJpa.repositories.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    ApplicantRepository applicantRepository;
    ResumeRepository resumeRepository;

    public ApplicantService(ApplicantRepository applicantRepository, ResumeRepository resumeRepository) {
        this.applicantRepository = applicantRepository;
        this.resumeRepository = resumeRepository;
    }

    public Applicant createApplicant(Applicant applicant){
        Resume resume = applicant.getResume();
        if(resume != null){
            resume.setApplicant(applicant);
        }
        List<Application> applications = applicant.getApplications();
        for(Application application : applications){
            application.setApplicant(applicant);
        }
        return this.applicantRepository.save(applicant);
    }


    public List<Applicant> getAllApplicant(){
        return this.applicantRepository.findAll();
    }
}
