package com.example.tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String creation;
    private String content;
    private String auteur;


    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getContent() {
        return content;
    }
    public String getCreation() {
        return creation;
    }
    public Long getId() {
        return id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreation(String creation) {
        this.creation = creation;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
