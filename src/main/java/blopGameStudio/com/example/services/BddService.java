package blopGameStudio.com.example.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import blopGameStudio.com.example.models.AnecdoticSecret;
import blopGameStudio.com.example.models.BelieveContent;
import blopGameStudio.com.example.models.City;
import blopGameStudio.com.example.models.Divinity;
import blopGameStudio.com.example.models.Job;
import blopGameStudio.com.example.models.Kingdom;
import blopGameStudio.com.example.models.Language;
import blopGameStudio.com.example.models.PrimordialSecret;
import blopGameStudio.com.example.models.Race;
import blopGameStudio.com.example.models.Region;
import blopGameStudio.com.example.models.Specialization;
import blopGameStudio.com.example.models.SpecializationContent;
import blopGameStudio.com.example.models.SpecializationSkill;
import blopGameStudio.com.example.models.Title;
import blopGameStudio.com.example.repositories.AnecdoticSecretRepository;
import blopGameStudio.com.example.repositories.JobRepository;
import blopGameStudio.com.example.repositories.KingdomRepository;
import blopGameStudio.com.example.repositories.LanguageRepository;
import blopGameStudio.com.example.repositories.PrimordialSecretRepository;
import blopGameStudio.com.example.repositories.RaceRepository;
import blopGameStudio.com.example.repositories.SpecializationRepository;
import blopGameStudio.com.example.repositories.TitleRepository;



import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BddService {

    private final AnecdoticSecretRepository anecdoticSecretRepository;
    private final PrimordialSecretRepository primordialSecretRepository;
    private final RaceRepository raceRepository;
    private final LanguageRepository languageRepository;
    private final JobRepository jobRepository;
    private final SpecializationRepository specializationRepository;
    private final KingdomRepository kingdomRepository;
    private final TitleRepository titleRepository;


    public BddService(AnecdoticSecretRepository anecdoticSecretRepository,
                      PrimordialSecretRepository primordialSecretRepository,
                      RaceRepository raceRepository,
                      LanguageRepository languageRepository,
                      JobRepository jobRepository,
                      SpecializationRepository specializationRepository,
                      KingdomRepository kingdomRepository,
                      TitleRepository titleRepository) {
        this.anecdoticSecretRepository = anecdoticSecretRepository;
        this.primordialSecretRepository = primordialSecretRepository;
        this.raceRepository = raceRepository;
        this.languageRepository = languageRepository;
        this.jobRepository = jobRepository;
        this.specializationRepository = specializationRepository;
        this.kingdomRepository = kingdomRepository;
        this.titleRepository = titleRepository;
    }

    public void insertBdd() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = getClass().getResourceAsStream("/data/AnecdoticSecret.json");
            AnecdoticSecret[] secretsArray = mapper.readValue(inputStream, AnecdoticSecret[].class);
            List<AnecdoticSecret> secretsList = Arrays.asList(secretsArray);
            anecdoticSecretRepository.saveAll(secretsList);

            InputStream inputStream2 = getClass().getResourceAsStream("/data/primordialSecret.json");
            PrimordialSecret[] primordialSecretsArray = mapper.readValue(inputStream2, PrimordialSecret[].class);
            List<PrimordialSecret> primordialSecretsList = Arrays.asList(primordialSecretsArray);
            primordialSecretRepository.saveAll(primordialSecretsList);

            InputStream inputStream3 = getClass().getResourceAsStream("/data/language.json");
            Language[] languageArray = mapper.readValue(inputStream3, Language[].class);
            List<Language> languageList = Arrays.asList(languageArray);
            languageRepository.saveAll(languageList);

            InputStream inputStream4 = getClass().getResourceAsStream("/data/race.json");
            Race[] racesArray = mapper.readValue(inputStream4, Race[].class);
            for (Race race : racesArray) {
                Set<Language> languages = new HashSet<>();
                for (Language language : race.getLanguages()) {
                    Language existingLanguage = languageRepository.findByName(language.getName());
                    if (existingLanguage != null) {
                        languages.add(existingLanguage);
                    } else {
                        Language newLanguage = new Language(language.getName(), language.getDescription());
                        languages.add(languageRepository.save(newLanguage));
                    }
                }
                race.setLanguages(languages);
                raceRepository.save(race);
            }

            InputStream inputStream5 = getClass().getResourceAsStream("/data/jobs.json");
            Job[] jobArray = mapper.readValue(inputStream5, Job[].class);
            List<Job> jobList = Arrays.asList(jobArray);
            jobRepository.saveAll(jobList);

            InputStream inputStream6 = getClass().getResourceAsStream("/data/specializations.json");
            Specialization[] specializationArray = mapper.readValue(inputStream6, Specialization[].class);
            for (Specialization specialization : specializationArray) {
                Set<Job> jobs = new HashSet<>();
                for (Job job : specialization.getJobs()) {
                    Job existingJob = jobRepository.findByName(job.getName());
                    if (existingJob != null) {
                        jobs.add(existingJob);
                    } else {
                        Job newJob = new Job(job.getName());
                        jobs.add(jobRepository.save(newJob));
                    }
                }
                specialization.setJobs(jobs);
                for (SpecializationSkill skill : specialization.getSpecializationSkill()) {
                    skill.setSpecialization(specialization);
                }
                for (SpecializationContent content : specialization.getSpecializationContents()) {
                    content.setSpecialization(specialization);
                }
                specializationRepository.save(specialization);
            }

            InputStream inputStream7 = getClass().getResourceAsStream("/data/kingdoms.json");
            Kingdom[] kingdomArray = mapper.readValue(inputStream7, Kingdom[].class);
            for (Kingdom kingdom : kingdomArray) {
                for (Region region : kingdom.getRegions()) {
                    region.setKingdom(kingdom);
                    for (City city : region.getCities()) {
                        city.setRegion(region);
                    }
                }
                for (Divinity divinity : kingdom.getDivinities()) {
                    divinity.setKingdom(kingdom);
                }
                for (BelieveContent believeContent : kingdom.getBelieveContents()) {
                    believeContent.setKingdom(kingdom);
                }
                kingdomRepository.save(kingdom);
            }

            InputStream inputStream8 = getClass().getResourceAsStream("/data/titles.json");
            Title[] titleArray = mapper.readValue(inputStream8, Title[].class);
            List<Title> titleList = Arrays.asList(titleArray);
            titleRepository.saveAll(titleList);

           

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
