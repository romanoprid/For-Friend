package ua.lviv.iot.spring.database.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.database.rest.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
