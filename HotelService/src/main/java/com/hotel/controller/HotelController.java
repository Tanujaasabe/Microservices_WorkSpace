package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.HotelEntity;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService S;
	
	@GetMapping
    public String test() {
        return "Hotel Service Running";
    }
	
	@PostMapping("/addhotel")
	public HotelEntity saveuser(@RequestBody HotelEntity h)
	{
		return S.saveuser(h);
	}
	
	@GetMapping("/gethotel")
	public List<HotelEntity>gethotel()
	{
		return S.gethotel();
	}
	
	@GetMapping("/{id}")
	public HotelEntity singlehotel(@PathVariable String id)
	{
	    System.out.println("ID = " + id);
	    return S.singlehotel(id);
	}
	
	@PutMapping("/updatehotel/{id}")
	public HotelEntity updatehotel(@PathVariable String id, @RequestBody HotelEntity E)
	{
		return S.updatehotel(id, E);
	}
	
	@DeleteMapping("/deletehotel/{id}")
	public String  deletehotel(@PathVariable String id)
	{
		return S.deletehotel(id);
	}
	
}
