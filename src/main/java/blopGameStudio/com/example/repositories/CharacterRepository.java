package blopGameStudio.com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import blopGameStudio.com.example.models.Character;


public interface CharacterRepository extends JpaRepository<Character,Integer>{

}
