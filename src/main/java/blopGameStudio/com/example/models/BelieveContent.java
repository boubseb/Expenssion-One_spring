package blopGameStudio.com.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BelievesDescription")
public class BelieveContent {

    @Id
    @GeneratedValue
    Integer id;
    Integer number;

    @Column(length = 3000)
    private String content;


    @ManyToOne
    @JoinColumn(name="kingdomId",referencedColumnName = "id")
    @JsonBackReference("kingdom-believeContent")
    private Kingdom kingdom;


    public BelieveContent() {
    }

    


    public BelieveContent(Integer number, String content, Kingdom kingdom) {
        this.number = number;
        this.content = content;
        this.kingdom = kingdom;
    }




    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public Kingdom getKingdom() {
        return kingdom;
    }


    public void setKingdom(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    

    

    
}
