package com.imooc.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubwayDTO {

    private Long id;

    private String name;
    private String cityEnName;
}
