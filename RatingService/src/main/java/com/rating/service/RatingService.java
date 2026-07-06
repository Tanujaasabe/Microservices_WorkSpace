package com.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.repo.RatingRepo;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepo R;
	

	public Rating create(Rating rating)
	{
		return R.save(rating);	
	}
	
	public List<Rating>getRating()
	{
		return R.findAll();
	}
	
	public List<Rating> getRatingByUserID(String userId)
	{
	    return R.findByUserId(userId);
	}
	
	public List<Rating> getRatingByHotelId(String hotelId)
	{
	    return R.findByHotelId(hotelId);
	}
	
	
}
