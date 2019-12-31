package com.luv2tech.controller;

import com.luv2tech.service.CityListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityListController {

    private final CityListService cityListService;

    public CityListController(CityListService cityListService) {
        this.cityListService = cityListService;
    }

    @GetMapping({"/state", "/state/"})
    public ResponseEntity<?> getStates(@RequestParam(name = "q") String q) {
        return cityListService.getStates(q);
    }

    @GetMapping({"/district", "/district/"})
    public ResponseEntity<?> getDistrict(@RequestParam(name = "q") String q) {
        return cityListService.getDistrict(q);
    }

    @GetMapping({"/town", "/town/"})
    public ResponseEntity<?> getTown(@RequestParam(name = "q") String q) {
        return cityListService.getTown(q);
    }
}
