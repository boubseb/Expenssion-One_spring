package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blopGameStudio.com.example.models.Job;


public interface JobRepository extends JpaRepository<Job, Integer>{
    Job findByName(String name);
}
