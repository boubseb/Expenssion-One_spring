package blopGameStudio.com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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




    public City() {
    }


    public City(String name, String description, Region region) {
        this.name = name;
        this.description = description;
        this.region = region;
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





    
    
}
