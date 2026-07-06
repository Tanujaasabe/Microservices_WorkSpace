package com.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Hotel")
@Data
public class HotelEntity {

    @Id
    private String id;

    private String name;
    private String location;
    private String about;


}
