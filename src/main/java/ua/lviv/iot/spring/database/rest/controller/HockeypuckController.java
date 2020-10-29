package ua.lviv.iot.spring.database.rest.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.database.rest.Hockeypuck;
import ua.lviv.iot.spring.database.rest.business.HockeypuckService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/hockeypucks")
@RestController
@RequiredArgsConstructor

public class HockeypuckController {


    @Autowired
    private HockeypuckService hockeypuckService;

    @GetMapping
    public List<Hockeypuck> getAllHockeypucks() {
        return hockeypuckService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hockeypuck> getHockeypuck(final @PathVariable("id") Integer hockeypuckId) {
        Hockeypuck hockeypuck = hockeypuckService.findById(hockeypuckId);
        if (hockeypuck != null) {
            return new ResponseEntity<>(hockeypuck, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Hockeypuck> createHockeypuck(@RequestBody Hockeypuck hockeyPuck) {
        Hockeypuck newHockeypuck = hockeypuckService.create(hockeyPuck);
        if (newHockeypuck != null) {
            return new ResponseEntity<>(newHockeypuck, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")

    public ResponseEntity<Object> updateHockeypuck(final @PathVariable("id") Integer hockeypuckId){
        Hockeypuck hockeypuck = hockeypuckService.findById(hockeypuckId);
        if (hockeypuck != null) {
            return new ResponseEntity<>(hockeypuck, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }








    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Hockeypuck> deleteHockeyPuck(final @PathVariable("id") Integer hockeyPuckId) {
        if (hockeypuckService.delete(hockeyPuckId) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

