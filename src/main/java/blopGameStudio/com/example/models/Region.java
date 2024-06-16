package blopGameStudio.com.example.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {


    @Id
    @GeneratedValue()
    Integer id;

    String name;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("region-city")
    List<City> cities;

    @ManyToOne
    @JoinColumn(name="kingdomId",referencedColumnName = "id")
    @JsonBackReference("kingdom-region")
    private Kingdom kingdom;

    public Region() {
    }

    public Region(String name, List<City> cities, Kingdom kingdom) {
        this.name = name;
        this.cities = cities;
        this.kingdom = kingdom;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    

    

}
