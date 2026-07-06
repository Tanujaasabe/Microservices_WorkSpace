package com.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.entity.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelClient {
	       @GetMapping("/hotels/{hotelId}")
          public  Hotel getsingleuser( @PathVariable String hotelId);
}