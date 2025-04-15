package com.revature.SpringDataJpa.entities;


import jakarta.persistence.*;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;


    private String Content;

    @OneToOne
    @JoinColumn(name = "applicantId", nullable = false)
    private Applicant applicant;

    public Resume() {
    }

    public Resume(String content, Applicant applicant) {
        Content = content;
        this.applicant = applicant;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

}
