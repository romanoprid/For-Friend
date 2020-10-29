package ua.lviv.iot.spring.database.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.database.rest.dataaccess.HockeypuckRepository;
import ua.lviv.iot.spring.database.rest.Hockeypuck;

import java.util.List;

@Service
public class HockeypuckService {
    @Autowired
    private HockeypuckRepository hockeypuckRepository;

    public Hockeypuck create(Hockeypuck hockeypuck) {
        return hockeypuckRepository.save(hockeypuck);
    }

    public Hockeypuck findById(Integer id) {
        return hockeypuckRepository.findById(id).orElse(null);
    }

    public List<Hockeypuck> findAll() {
        return hockeypuckRepository.findAll();
    }

    public Hockeypuck updateHockeyPuck(Integer id, Hockeypuck newHockeypuck) {
        Hockeypuck hockeypuck = hockeypuckRepository.getOne(id);
        hockeypuck = newHockeypuck;
        return hockeypuckRepository.save(hockeypuck);
    }


    public Hockeypuck delete(Integer id) {
        Hockeypuck hockeypuck = hockeypuckRepository.findById(id).get();
        hockeypuckRepository.deleteById(id);
        return hockeypuck;
    }
}

