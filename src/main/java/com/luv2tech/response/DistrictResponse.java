package com.luv2tech.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class DistrictResponse {

    private String town;
    private String urban_status;
    private Integer state_code;
    private String state;
    private Integer district_code;
    private String district;

    public DistrictResponse(String town, String urban_status, Integer state_code,
                            String state, Integer district_code, String district) {
        this.town = town;
        this.urban_status = urban_status;
        this.state_code = state_code;
        this.state = state;
        this.district_code = district_code;
        this.district = district;
    }
}
