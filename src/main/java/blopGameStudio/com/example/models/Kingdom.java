package blopGameStudio.com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "kingdoms")
public class Kingdom {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;


    private String description;




    @OneToMany(mappedBy = "kingdom",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("kingdom-divinity")
    private List<Divinity> divinities;


    @OneToMany(mappedBy = "kingdom",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("kingdom-region")
    private List<Region> regions;

    @OneToMany(mappedBy = "kingdom",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("kingdom-believeContent")
    @JsonProperty("believeDescription")
    private List<BelieveContent> believeContents;



    public Kingdom() {
    }



    public Kingdom(String name, String description, List<Divinity> divinities,
            List<Region> regions, List<BelieveContent> believeContents) {
        this.name = name;
        this.description = description;
        this.divinities = divinities;
        this.regions = regions;
        this.believeContents = believeContents;
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



    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Divinity> getDivinities() {
        return divinities;
    }

    public void setDivinities(List<Divinity> divinities) {
        this.divinities = divinities;
    }

    public List<BelieveContent> getBelieveContents() {
        return believeContents;
    }

    public void setBelieveContents(List<BelieveContent> believeContents) {
        this.believeContents = believeContents;
    }

}
