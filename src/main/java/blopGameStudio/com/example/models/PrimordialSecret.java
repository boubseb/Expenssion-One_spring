package blopGameStudio.com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PrimordialSecrets")
public class PrimordialSecret {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String description;

    @OneToMany(mappedBy = "primordialSecret")
    @JsonManagedReference("primordialSecret-character")
    @JsonIgnore
    private List<Character> characters;

    
    public PrimordialSecret(Integer number, String description) {
        this.number = number;
        this.description = description;
    }

    

    
    public PrimordialSecret(Integer number, String description, List<Character> characters) {
        this.number = number;
        this.description = description;
        this.characters = characters;
    }




    public PrimordialSecret() {
    }


    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public List<Character> getCharacters() {
        return characters;
    }


    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    

    
}