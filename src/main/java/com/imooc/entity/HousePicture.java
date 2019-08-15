package com.imooc.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "house_picture")
@Data
public class HousePicture {

    private int id;

    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    private int width;

    private int height;

    private String location;

    private String path;
}
