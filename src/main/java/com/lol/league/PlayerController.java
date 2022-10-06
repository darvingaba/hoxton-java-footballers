package com.lol.league;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }
    @PostMapping("/team/{teamId}/players")
    public Player createPlayer(@RequestBody Player playerData, @PathVariable Integer teamId) {
    playerData.team = teamRepository.findById(teamId).get();
    return playerRepository.save(playerData);
  }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getSinglePlayer(@PathVariable Integer id) {
    Optional<Player> match = playerRepository.findById(id);

    if (match.isPresent()) {
      return new ResponseEntity<>(match.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }  

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable Integer id) {
    playerRepository.deleteById(id);
    return "SUCCESSFULLY DELETED!";
  }
//     @PatchMapping("/players/{id}")
//     public Player updateplayer(@RequestBody Player playerData, @PathVariable Integer id) {
//     playerData.scoreOutOfTen = ;
//     return playerRepository.save(playerData);
//   }
// not finished

    //  void showScore(){
    //     for(Player player:playerRepository.findAll()){
    //         public Integer score ;
    //     }
    // }
       

}
interface PlayerRepository extends JpaRepository<Player,Integer>{}
interface TeamRepository extends JpaRepository<Team,Integer>{}
