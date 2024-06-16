package blopGameStudio.com.example.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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
    private String pseudo;
    private String lastnname;
    private String firstname;
    private String password;
    private String email;
    private String profilPictureUrl;
    private String biography;
    private Date dateOfBirth;
    
    private Set<User> friends;
    
    private Set<Calendar> calendars;

    private Boolean isNewletters;
    private Boolean isPublic;


    
    @ManyToOne
    @JoinColumn(name = "Character_id")
    private List<Character> character;

    // Getters and Setters
}