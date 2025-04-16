package com.revature.SpringDataJpa.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String status;

    private String position;

    @ManyToOne
    @JoinColumn(name = "applicationId", nullable = false)
    @JsonIgnore
    private Applicant applicant;

    public Application() {
    }

    public Application(String status, String position, Applicant applicant) {
        this.status = status;
        this.position = position;
        this.applicant = applicant;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
