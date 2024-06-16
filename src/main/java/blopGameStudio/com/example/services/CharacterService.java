package blopGameStudio.com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import blopGameStudio.com.example.models.Character;
import blopGameStudio.com.example.repositories.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Transactional(readOnly = true)
    public Character getCharacterById(Integer id) {
        return characterRepository.findById(id).orElseThrow(() -> new RuntimeException("Character not found"));
    }
}
