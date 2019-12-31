package com.luv2tech.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city_list")
public class CityList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, name = "town")
    private String town;
    @Column(name = "urban_status")
    private String urbanStatus;
    @Column(name = "state_code")
    private Integer stateCode;
    @Column(name = "state")
    private String state;
    @Column(name = "district_code")
    private Integer districtCode;
    @Column(name = "district")
    private String district;
}
