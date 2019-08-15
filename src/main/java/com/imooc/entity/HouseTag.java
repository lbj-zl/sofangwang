package com.imooc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "house_tag")
@Data
public class HouseTag {

    private Long id;

    @Column(name = "house_id")
    private Long houseId;

    private String name;
}
