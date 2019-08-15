package com.imooc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subway")
@Data
public class SubWay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city_en_name")
    private String cityEnName;
}
