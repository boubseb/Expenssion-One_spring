package blopGameStudio.com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    private Integer id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "Character_id")
    private Character character;

    // Getters and Setters
}