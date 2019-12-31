package com.luv2tech.service;

import com.luv2tech.model.CityList;
import com.luv2tech.repository.CityListRepository;
import com.luv2tech.response.DistrictResponse;
import com.luv2tech.response.StateResponse;
import com.luv2tech.response.TownResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CityListServiceImpl implements CityListService {

    private final CityListRepository cityListRepository;

    public CityListServiceImpl(CityListRepository cityListRepository) {
        this.cityListRepository = cityListRepository;
    }

    @Override
    public ResponseEntity<?> getStates(String q) {
        List<CityList> cityLists = cityListRepository.findByStateContaining(q);
        List<StateResponse> responses = cityLists.stream()
                .filter(distinctByKey(CityList::getDistrictCode))
                .map(s -> new StateResponse(s.getState(), s.getDistrictCode(), s.getDistrict()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getTown(String q) {
        List<CityList> cityLists = cityListRepository.findByTownContaining(q);
        List<TownResponse> responses = cityLists.stream()
                .map(s -> new TownResponse(s.getTown(), s.getState(), s.getDistrict()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getDistrict(String q) {
        List<CityList> cityLists = cityListRepository.findByDistrictContaining(q);
        List<DistrictResponse> responses = cityLists.stream()
                .map(s -> new DistrictResponse(s.getTown(),
                        s.getUrbanStatus(), s.getStateCode(), s.getState(),
                        s.getDistrictCode(), s.getDistrict()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
