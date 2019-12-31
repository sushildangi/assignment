package com.luv2tech.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class StateResponse {

    private String state;
    private Integer district_code;
    private String district;

    public StateResponse(String state, Integer district_code, String district) {
        this.state = state;
        this.district_code = district_code;
        this.district = district;
    }
}
