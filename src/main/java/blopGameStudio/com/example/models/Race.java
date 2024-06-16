package blopGameStudio.com.example.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Races")
public class Race {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "racialTrait")
    @JsonProperty("racial_trait")
    private String racialTrait;

    @JsonProperty("min_age")
    private Integer minAge;

    @JsonProperty("max_age")
    private Integer maxAge;

    @JsonProperty("min_height")
    private Integer minHeight;

    @JsonProperty("max_height")
    private Integer maxHeight;

    @JsonProperty("min_speed")
    private Integer minSpeed;

    @JsonProperty("max_speed")
    private Integer maxSpeed;


    @ManyToMany
    @JoinTable(
        name = "race_language",
        joinColumns = @JoinColumn(name = "raceId"),
        inverseJoinColumns = @JoinColumn(name = "languageId")
    )
    private Set<Language> languages;

    
    @JsonProperty("number_additional_language")
    private Integer numberAdditionalLanguage;

    @JsonProperty("url")
    private String imageUrl;




    
    public Race(String name, String description, String racialTrait, Integer minAge, Integer maxAge, Integer minHeight,
            Integer maxHeight, Integer minSpeed, Integer maxSpeed, Set<Language> languages,
            Integer numberAdditionalLanguage, String imageUrl) {
        this.name = name;
        this.description = description;
        this.racialTrait = racialTrait;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.languages = languages;
        this.numberAdditionalLanguage = numberAdditionalLanguage;
        this.imageUrl = imageUrl;
    }
    public Race(){}

    


    public Integer getMaxSpeed() {
        return maxSpeed;
    }



    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }




    public Integer getNumberAdditionalLanguage() {
        return numberAdditionalLanguage;
    }



    public void setNumberAdditionalLanguage(Integer numberAdditionalLanguage) {
        this.numberAdditionalLanguage = numberAdditionalLanguage;
    }



    public String getImageUrl() {
        return imageUrl;
    }



    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer categoryId) {
        this.id = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRacialTrait() {
        return racialTrait;
    }
    public void setRacialTrait(String racialTraits) {
        this.racialTrait = racialTraits;
    }
    public Integer getMinAge() {
        return minAge;
    }
    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }
    public Integer getMaxAge() {
        return maxAge;
    }
    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }
    public Integer getMinHeight() {
        return minHeight;
    }
    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }
    public Integer getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }
    public Integer getMinSpeed() {
        return minSpeed;
    }
    public void setMinSpeed(Integer speed) {
        this.minSpeed = speed;
    }



    public Set<Language> getLanguages() {
        return languages;
    }



    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }


    
}