package com.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.HotelEntity;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity,String> {

}
