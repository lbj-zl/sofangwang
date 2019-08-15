package com.imooc.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubwayStationDTO {

    private Long id;
    private Long subwayId;

    private String name;
}
