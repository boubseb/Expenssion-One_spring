package blopGameStudio.com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Locations")
public class Location {
    
    @Id
    private Integer id;
    private String name;
    private String url;

    // Getters and Setters
}
