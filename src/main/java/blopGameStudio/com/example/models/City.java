package blopGameStudio.com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

  @Column(length = 1000)
    private String description;


    @ManyToOne
    @JoinColumn(name="regionId",referencedColumnName = "id")
    @JsonBackReference("region-city")
    private Region region;

    @OneToMany(mappedBy = "liveCity",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("liveCity-character")
    @JsonIgnore
    private List<Character> characters;

    @OneToMany(mappedBy = "bornCity",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("bornCity-character")
    @JsonIgnore
    private List<Character> characters2;


    public City() {
    }


    public City(String name, String description, Region region) {
        this.name = name;
        this.description = description;
        this.region = region;
    }

    




    public City(String name, String description, Region region, List<Character> characters) {
        this.name = name;
        this.description = description;
        this.region = region;
        this.characters = characters;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
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


    public Region getRegion() {
        return region;
    }


    public void setRegion(Region region) {
        this.region = region;
    }


    public List<Character> getCharacters() {
        return characters;
    }


    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }


    
    
}
