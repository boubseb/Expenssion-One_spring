package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blopGameStudio.com.example.models.Race;

public interface RaceRepository extends JpaRepository<Race, Integer> {
}

