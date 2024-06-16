package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blopGameStudio.com.example.models.Title;

public interface TitleRepository extends JpaRepository<Title,Integer> {

}
