package com.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.client.HotelClient;
import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo R;
	
	@Autowired
	private HotelClient hotelclient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);
	
	
	public User saveuser(User user)
	{
		return R.save(user);
	}
	
	public List<User> getuser()
	{
		return R.findAll();
	}
	
	
    public User getsingleuser(String id) {
    	User user= R.findById(id).orElseThrow();
    	 //fetch rating above user from  the rating service
    	//http://localhost:8083/rating/users/U101
    	
    	Rating[] ratingofuser =restTemplate.getForObject("http://RATINGSERVICE/rating/users/"+user.getUserid(),Rating[].class);
    	logger.info("{}", ratingofuser);
    	
    	
    	
    	
 
    	
    	
    	  List<Rating>ratings=Arrays.stream(ratingofuser).toList();
    	  
    	List<Rating> ratinglist=ratings.stream().map(rating->{
    		//api caal to hotel services fetch hotel 
    		//http://localhost:8082/hotels/gethotel
    		
    	 Hotel hotel=hotelclient.getsingleuser(rating.getHotelId());
    	 rating.setHotel(hotel);
    	 
    		return rating;
 	
    		
    	}).collect(Collectors.toList());
    	
    	user.setRatings(ratinglist);
    	return user;
	}
	
	public User updateuser(String id,User user)
	{
		User u=R.findById(id).orElseThrow();
		if(u!=null)
		{
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setAbout(user.getAbout());
			return R.save(u);
		}
		return u;
	}
	
	public String deleteuser(String id)
	{
	     R.deleteById(id);
		return "delete user";
	}

	

}
