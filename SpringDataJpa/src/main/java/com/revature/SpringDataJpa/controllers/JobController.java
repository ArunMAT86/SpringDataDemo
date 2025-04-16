package com.revature.SpringDataJpa.controllers;


import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Jobs;
import com.revature.SpringDataJpa.services.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jobs")
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping(path = "/")
    public Jobs createJob(@RequestBody Jobs job){
        return this.jobService.saveJob(job);
    }

    @PostMapping(path = "/add-job-to-applicant/{applicantid}/{jobid}")
    ResponseEntity<Applicant> addJobToApplicant(@PathVariable("applicantid") Integer applicantid, @PathVariable("jobid") Integer jobid){
        Applicant updatedApplicant = jobService.addjobsToApplicant(applicantid,jobid);
        return ResponseEntity.ok(updatedApplicant);
    }



}
