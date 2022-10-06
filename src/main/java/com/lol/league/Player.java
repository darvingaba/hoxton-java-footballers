package com.lol.league;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String nationality;
    public Integer scoreOutOfTen;
    public Boolean isReplacement;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="teamId", nullable=true) Team team;

    public Player(){
        
    }
}
