package com.revature.SpringDataJpa.controllers;


import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.services.ApplicantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

   ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/")
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        return this.applicantService.createApplicant(applicant);
    }

    @GetMapping("/")
    public List<Applicant> retrieveAllApplicant(){
        return this.applicantService.getAllApplicant();
    }

}
