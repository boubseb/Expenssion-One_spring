package blopGameStudio.com.example.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import blopGameStudio.com.example.models.AnecdoticSecret;
import blopGameStudio.com.example.models.Character;
import blopGameStudio.com.example.models.Job;
import blopGameStudio.com.example.models.Kingdom;
import blopGameStudio.com.example.models.PrimordialSecret;
import blopGameStudio.com.example.models.Race;
import blopGameStudio.com.example.models.Specialization;
import blopGameStudio.com.example.models.Title;
import blopGameStudio.com.example.repositories.AnecdoticSecretRepository;
import blopGameStudio.com.example.repositories.CharacterRepository;
import blopGameStudio.com.example.repositories.JobRepository;
import blopGameStudio.com.example.repositories.KingdomRepository;
import blopGameStudio.com.example.repositories.LanguageRepository;
import blopGameStudio.com.example.repositories.PrimordialSecretRepository;
import blopGameStudio.com.example.repositories.RaceRepository;
import blopGameStudio.com.example.repositories.SpecializationRepository;
import blopGameStudio.com.example.repositories.TitleRepository;


@RestController
public class charactersController {

    private final  CharacterRepository characterRepository;
    private final AnecdoticSecretRepository anecdoticSecretRepository;
    private final SpecializationRepository specializationRepository;
    private final PrimordialSecretRepository primordialSecretRepository;
    private final RaceRepository raceRepository;
    private final LanguageRepository languageRepository;
    private final JobRepository jobRepository;
    private final KingdomRepository kingdomRepository;
    private final TitleRepository titleRepository;
    


    public charactersController(CharacterRepository characterRepository,
    AnecdoticSecretRepository anecdoticSecretRepository,SpecializationRepository specializationRepository,
    PrimordialSecretRepository primordialSecretRepository,RaceRepository raceRepository,
    LanguageRepository languageRepository,JobRepository jobRepository,KingdomRepository kingdomRepository,
    TitleRepository titleRepository) {
        this.characterRepository = characterRepository;
        this.anecdoticSecretRepository=anecdoticSecretRepository;
        this.primordialSecretRepository = primordialSecretRepository;
        this.raceRepository = raceRepository;
        this.languageRepository = languageRepository;
        this.jobRepository=jobRepository;
        this.specializationRepository=specializationRepository;
        this.kingdomRepository=kingdomRepository;
        this.titleRepository=titleRepository;
    }


    @PutMapping("/addCharacter")
    public void addCharacter() throws StreamReadException, DatabindException, IOException {


        InputStream inputStream = getClass().getResourceAsStream("/data/character.json");
        ObjectMapper mapper = new ObjectMapper();
        Character character = mapper.readValue(inputStream, Character.class);
        characterRepository.save(character);
       
    }

        @GetMapping("test/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Integer id) {
        Optional<Character> characterOptional = characterRepository.findById(id);

        if (characterOptional.isPresent()) {
            Character character = characterOptional.get();
        
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("specializations")
    public List<Specialization> getSpecializations() {
       return specializationRepository.findAll();
    }

    @GetMapping("anecdoticSecrects")
    public List<AnecdoticSecret> getAnecdoticSecrects() {
       return anecdoticSecretRepository.findAll();
    }

    @GetMapping("primordialSecrects")
    public List<PrimordialSecret> getPrimordialSecrects() {
       return primordialSecretRepository.findAll();
    }

    @GetMapping("jobs")
    public List<Job> getJobs() {
       return jobRepository.findAll();
    }

    @GetMapping("titles")
    public List<Title> getTitles() {
       return titleRepository.findAll();
    }

    @GetMapping("races")
    public List<Race> getRaces() {
       return raceRepository.findAll();
    }

    @GetMapping("kingdoms")
    public List<Kingdom> getKingdoms() {
       return kingdomRepository.findAll();
    }








    
    
}
