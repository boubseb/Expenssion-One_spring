package blopGameStudio.com.example.models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import blopGameStudio.com.example.models.Character;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique=true,updatable = false)
    private String pseudo;
    private String lastnname;
    private String firstname;
    private String password;
    @Column(unique=true,updatable = true)
    private String email;
    private String profilPictureUrl=null;
    private String biography=null;
    private Date dateOfBirth;
    
    //private Set<User> friends=null;
    


    private Boolean isNewletters=true;
    private Boolean isPublic=true;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("user-character")
    private List<Character> characters;

    
    


    public User(Date dateOfBirth, String email, String firstname, String lastnname, String password, String pseudo) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstname = firstname;
        this.lastnname = lastnname;
        this.password = password;
        this.pseudo = pseudo;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getLastnname() {
        return lastnname;
    }

    public void setLastnname(String lastnname) {
        this.lastnname = lastnname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilPictureUrl() {
        return profilPictureUrl;
    }

    public void setProfilPictureUrl(String profilPictureUrl) {
        this.profilPictureUrl = profilPictureUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // public Set<User> getFriends() {
    //     return friends;
    // }

    // public void setFriends(Set<User> friends) {
    //     this.friends = friends;
    // }



    public Boolean getIsNewletters() {
        return isNewletters;
    }

    public void setIsNewletters(Boolean isNewletters) {
        this.isNewletters = isNewletters;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Character> getCharacter() {
        return characters;
    }

    public void setCharacter(List<Character> characters) {
        this.characters = characters;
    }

}