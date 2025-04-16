package com.revature.SpringDataJpa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "jobs")
    @JsonIgnore
    private List<Applicant> applicant = new ArrayList<>();

    public Jobs() {
    }

    public Jobs(String title, String description, List<Applicant> applicant) {
        this.title = title;
        this.description = description;
        this.applicant = applicant;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Applicant> getApplicant() {
        return applicant;
    }

    public void setApplicant(List<Applicant> applicant) {
        this.applicant = applicant;
    }
}
