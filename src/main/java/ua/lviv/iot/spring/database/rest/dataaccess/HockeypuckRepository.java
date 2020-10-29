package ua.lviv.iot.spring.database.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.database.rest.Hockeypuck;

@Repository
public interface HockeypuckRepository extends JpaRepository<Hockeypuck, Integer> {
}
