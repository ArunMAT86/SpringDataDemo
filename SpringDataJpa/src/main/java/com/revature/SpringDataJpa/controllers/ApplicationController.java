package com.revature.SpringDataJpa.controllers;


import com.revature.SpringDataJpa.entities.Application;
import com.revature.SpringDataJpa.services.ApplicantService;
import com.revature.SpringDataJpa.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/applications")
public class ApplicationController {


 ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(path = "/{applicant_id}")
    public ResponseEntity<Application> createApplication(@PathVariable Integer applicant_id, @RequestBody Application application){

        return ResponseEntity.ok(applicationService.saveApplication(applicant_id, application));
    }


}
