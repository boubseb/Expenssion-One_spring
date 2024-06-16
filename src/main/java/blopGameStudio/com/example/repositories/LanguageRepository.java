package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blopGameStudio.com.example.models.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    Language findByName(String name);

}
