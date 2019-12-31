package com.luv2tech.service;

import org.springframework.http.ResponseEntity;

public interface CityListService {

    ResponseEntity<?> getStates(String q);

    ResponseEntity<?> getTown(String q);

    ResponseEntity<?> getDistrict(String q);
}
