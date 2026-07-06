package com.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.userservice.entity.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingClient {
	
	@PostMapping("/rating/create")
	public Rating createRating(Rating values);
	
	@PutMapping("/rating/{ratingId}")
	public Rating updaterate(@PathVariable String ratingId,Rating rate);
	
    @DeleteMapping("/rating/{ratingId}")
	public Rating deletedata(@PathVariable String ratingId);
}
