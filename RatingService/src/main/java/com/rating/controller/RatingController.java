package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService S;
	
	
	@GetMapping
	public String test()
	{
		return"rating service client";
	}
	
	@PostMapping("/create")
	public Rating create(@RequestBody Rating rating)
	{
		return S.create(rating);
		
	}
	
	@GetMapping("/show")
	public List<Rating>getRating()
	{
		return S.getRating();
	}
	
	@GetMapping("/users/{userId}")
	public List<Rating> getRatingByUserID(@PathVariable("userId") String userId) {
	    return S.getRatingByUserID(userId);
	    
	   
	}

	@GetMapping("/hotels/{hotelId}")
	public List<Rating> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
	    return S.getRatingByHotelId(hotelId);
	}
	
}
