package com.imooc.web.form;

import lombok.Data;
import lombok.ToString;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ����.
 */
@Data
public class HouseForm {
    private Long id;

    @NotNull(message = "����ⲻ����Ϊ��!")
    @Size(min = 1, max = 30, message = "���ⳤ�ȱ�����1~30֮��")
    private String title;

    @NotNull(message = "����ѡ��һ������")
    @Size(min = 1, message = "�Ƿ��ĳ���")
    private String cityEnName;

    @NotNull(message = "����ѡ��һ������")
    @Size(min = 1, message = "�Ƿ��ĵ���")
    private String regionEnName;

    @NotNull(message = "������д�ֵ�")
    @Size(min = 1, message = "�Ƿ��Ľֵ�")
    private String street;

    @NotNull(message = "������дС��")
    private String district;

    @NotNull(message = "��ϸ��ַ������Ϊ��!")
    @Size(min = 1, max = 30, message = "��ϸ��ַ���ȱ�����1~30֮��")
    private String detailAddress;

    @NotNull(message = "������д��������")
    @Min(value = 1, message = "�Ƿ�����������")
    private Integer room;

    private int parlour;

    @NotNull(message = "������д����¥��")
    private Integer floor;

    @NotNull(message = "������д��¥��")
    private Integer totalFloor;

    @NotNull(message = "������д���ݳ���")
    private Integer direction;

    @NotNull(message = "������д������ʼʱ��")
    @Min(value = 1900, message = "�Ƿ��Ľ�����ʼʱ��")
    private Integer buildYear;

    @NotNull(message = "������д���")
    @Min(value = 1)
    private Integer area;

    @NotNull(message = "������д���޼۸�")
    @Min(value = 1)
    private Integer price;

    @NotNull(message = "����ѡ��һ�����޷�ʽ")
    @Min(value = 0)
    @Max(value = 1)
    private Integer rentWay;

    private Long subwayLineId;

    private Long subwayStationId;

    private int distanceToSubway = -1;

    private String layoutDesc;

    private String roundService;

    private String traffic;

    @Size(max = 255)
    private String description;

    private String cover;

    private List<String> tags;

    private List<PhotoForm> photos;
}
