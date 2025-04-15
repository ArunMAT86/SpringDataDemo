package com.revature.SpringDataJpa.repositories;

import com.revature.SpringDataJpa.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
