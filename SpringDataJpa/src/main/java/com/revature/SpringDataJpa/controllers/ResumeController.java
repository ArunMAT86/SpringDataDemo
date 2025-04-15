package com.revature.SpringDataJpa.controllers;


import com.revature.SpringDataJpa.entities.Resume;
import com.revature.SpringDataJpa.services.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Resume> addResume(@PathVariable Integer id, @RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(id, resume));
    }
}
