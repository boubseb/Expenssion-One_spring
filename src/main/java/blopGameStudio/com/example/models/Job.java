package blopGameStudio.com.example.models;

import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "jobs")
    private Set<Specialization> specializations;

    @OneToMany(mappedBy = "additionalJob",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("job-character")
    private List<Character> characters;

    public Job(){}

    public Job(String name) {
        this.name = name;
    }

    

    public Job(String name, Set<Specialization> specializations, List<Character> characters) {
        this.name = name;
        this.specializations = specializations;
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

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    




    

}
