package ua.lviv.iot.spring.database.rest.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.database.rest.Player;
import ua.lviv.iot.spring.database.rest.business.PlayerService;

import java.util.List;


@RequestMapping("/players")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class PlayerController {


    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayer() {
        return playerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Player> getPlayer(final @PathVariable("id") Integer playerId) {
        Player player = playerService.findById(playerId);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.create(player);
        if (newPlayer != null) {
            return new ResponseEntity<>(newPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")

    public ResponseEntity<Object> updatePlayer(final @PathVariable("id") Integer playerId){
        Player player = playerService.findById(playerId);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }








    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Player> deletePlayer(final @PathVariable("id") Integer playerId) {
        if (playerService.delete(playerId) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

