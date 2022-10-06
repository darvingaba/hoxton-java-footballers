package com.lol.league;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }
}
interface PlayerRepository extends JpaRepository<Player,Integer>{}
