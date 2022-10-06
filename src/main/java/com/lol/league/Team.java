package com.lol.league;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;

    public Team(){
        
    }
}
