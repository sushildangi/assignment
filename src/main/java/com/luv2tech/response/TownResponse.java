package com.luv2tech.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class TownResponse {
    private String town;
    private String state;
    private String district;

    public TownResponse(String town, String state, String district) {
        this.town = town;
        this.state = state;
        this.district = district;
    }
}
