package com.userservice.entity;

import java.util.ArrayList;
import lombok.Builder;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="Micro_User")
@Builder
public class User {
	@Id
private String userid;
private String name;
private String email;
private String about;


@Transient
 private List<Rating>ratings=new ArrayList<>();
}
