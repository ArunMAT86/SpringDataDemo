package com.revature.SpringDataJpa.controllers;


import com.revature.SpringDataJpa.Exception.NotFoundException;
import com.revature.SpringDataJpa.entities.Applicant;
import com.revature.SpringDataJpa.entities.Application;
import com.revature.SpringDataJpa.services.ApplicantService;
import com.revature.SpringDataJpa.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/applications")
public class ApplicationController {


 ApplicationService applicationService;
 ApplicantService applicantService;

    public ApplicationController(ApplicationService applicationService, ApplicantService applicantService) {
        this.applicationService = applicationService;
        this.applicantService = applicantService;
    }


    @PostMapping(path = "/{applicant_id}")
    public ResponseEntity<Application> createApplication(@PathVariable Integer applicant_id, @RequestBody Application application){
      Applicant applicant = applicantService.getApplicantById(applicant_id)
              .orElseThrow(()->new NotFoundException("Not found" + applicant_id));
        return ResponseEntity.ok(applicationService.saveApplication(applicant_id, application));
    }


}
