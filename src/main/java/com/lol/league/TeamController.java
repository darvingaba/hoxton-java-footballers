package com.lol.league;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public List<Team> getTeams(){
        return teamRepository.findAll();
    }
    @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }
}
interface TeamRepository extends JpaRepository<Team,Integer>{}

