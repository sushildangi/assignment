package com.luv2tech.repository;

import com.luv2tech.model.CityList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityListRepository extends JpaRepository<CityList, Long> {

    List<CityList> findByStateContaining(String q);

    List<CityList> findByTownContaining(String q);

    List<CityList> findByDistrictContaining(String q);
}
