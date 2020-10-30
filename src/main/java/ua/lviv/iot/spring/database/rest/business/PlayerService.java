package ua.lviv.iot.spring.database.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.database.rest.dataaccess.PlayerRepository;
import ua.lviv.iot.spring.database.rest.Player;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player create(Player player) {
        return playerRepository.save(player);
    }

    public Player findById(Integer id) {
        return playerRepository.findById(id).orElse(null);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player updatePlayer(Integer id, Player newPlayer) {
        Player player = playerRepository.getOne(id);
        player = newPlayer;
        return playerRepository.save(player);
    }


    public Player delete(Integer id) {
        Player player = playerRepository.findById(id).get();
        playerRepository.deleteById(id);
        return player;
    }
}

