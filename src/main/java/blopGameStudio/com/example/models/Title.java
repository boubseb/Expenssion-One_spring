package blopGameStudio.com.example.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Titles")
public class Title {
    
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;


     @ManyToMany(mappedBy = "titles")
    @JsonIgnore
    private Set<Character> characters;
    

    public Title(){}
    public Title(String name, String description) {
        this.name = name;
        this.description = description;
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
    public Set<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    

    
}
