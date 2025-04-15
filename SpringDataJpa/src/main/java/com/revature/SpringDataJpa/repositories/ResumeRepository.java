package com.revature.SpringDataJpa.repositories;


import com.revature.SpringDataJpa.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Integer> {

}
