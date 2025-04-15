package com.revature.SpringDataJpa.services;


import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Resume;
import com.revature.SpringDataJpa.repositories.ApplicantRepository;
import com.revature.SpringDataJpa.repositories.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    ResumeRepository resumeRepository;
    ApplicantRepository applicantRepository;

    public ResumeService(ApplicantRepository applicantRepository, ResumeRepository resumeRepository) {
        this.applicantRepository = applicantRepository;
        this.resumeRepository = resumeRepository;
    }

    public Resume addResume(Integer id, Resume resume){
        Optional<Applicant> applicantOptional = applicantRepository.findById(id);

        if (applicantOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
              return this.resumeRepository.save(resume);
        }else {

            throw new RuntimeException("Application id is not present "+ id);
        }




    }
}
