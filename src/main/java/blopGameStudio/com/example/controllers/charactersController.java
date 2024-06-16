package blopGameStudio.com.example.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Optional;

import blopGameStudio.com.example.models.AnecdoticSecret;
import blopGameStudio.com.example.models.BelieveContent;
import blopGameStudio.com.example.models.Character;
import blopGameStudio.com.example.models.City;
import blopGameStudio.com.example.models.Divinity;
import blopGameStudio.com.example.models.Kingdom;
import blopGameStudio.com.example.models.Region;
import blopGameStudio.com.example.repositories.AnecdoticSecretRepository;
import blopGameStudio.com.example.repositories.CharacterRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class charactersController {

    CharacterRepository characterRepository;
    AnecdoticSecretRepository anecdoticSecretRepository;

    


    public charactersController(CharacterRepository characterRepository,AnecdoticSecretRepository anecdoticSecretRepository) {
        this.characterRepository = characterRepository;
        this.anecdoticSecretRepository=anecdoticSecretRepository;
    }


    @PutMapping("/addCharacter")
    public Optional<Character> addCharacter() throws StreamReadException, DatabindException, IOException {


        InputStream inputStream = getClass().getResourceAsStream("/data/character.json");
        ObjectMapper mapper = new ObjectMapper();
        Character character = mapper.readValue(inputStream, Character.class);

        character.setAnecdoticSecret(anecdoticSecretRepository.getReferenceById(1));



        characterRepository.save(character);
        return characterRepository.findById(1);
    }

        @GetMapping("test/{id}")
    public ResponseEntity<AnecdoticSecret> getCharacterById(@PathVariable Integer id) {
        Optional<Character> characterOptional = characterRepository.findById(id);

        if (characterOptional.isPresent()) {
            Character character = characterOptional.get();
        
            return ResponseEntity.ok(character.getAnecdoticSecret());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
