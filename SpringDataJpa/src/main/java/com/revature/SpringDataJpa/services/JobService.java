package com.revature.SpringDataJpa.services;


import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Jobs;
import com.revature.SpringDataJpa.repositories.ApplicantRepository;
import com.revature.SpringDataJpa.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    JobRepository jobRepository;
    ApplicantRepository applicantRepository;

    public JobService(JobRepository jobRepository, ApplicantRepository applicantRepository) {
        this.jobRepository = jobRepository;
        this.applicantRepository = applicantRepository;
    }

    public Jobs saveJob(Jobs job){
        return this.jobRepository.save(job);
    }

    public Applicant addjobsToApplicant(Integer applicantId, Integer jobId){

        Optional<Applicant> applicantOptional = applicantRepository.findById(applicantId);
        Optional<Jobs> jobsOptional = jobRepository.findById(jobId);

        if(applicantOptional.isPresent() && jobsOptional.isPresent()){
            Applicant applicant = applicantOptional.get();
            applicant.getJobs().add(jobsOptional.get());
            applicantRepository.save(applicant);
            return applicant;
        }else {
            throw new IllegalArgumentException("not found");
        }

    }
}
