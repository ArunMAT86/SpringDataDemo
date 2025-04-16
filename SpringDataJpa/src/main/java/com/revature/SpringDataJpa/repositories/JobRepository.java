package com.revature.SpringDataJpa.repositories;


import com.revature.SpringDataJpa.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer> {

}
