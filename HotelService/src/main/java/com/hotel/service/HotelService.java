package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.HotelEntity;
import com.hotel.repo.HotelRepo;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepo R;

	public HotelEntity saveuser(HotelEntity h)
	{
		return R.save(h);
	}
	
	public List<HotelEntity>gethotel()
	{
		return R.findAll();
	}
	
	public HotelEntity updatehotel(String id,HotelEntity E)
	{
		HotelEntity Entity=R.findById(id).orElseThrow();
		if(Entity !=null)
		{
			Entity.setName(E.getName());
			Entity.setAbout(E.getAbout());
			Entity.setLocation(E.getLocation());
			R.save(Entity);
		}
		return Entity;
	}
	
	public String  deletehotel(String id) {
		
		R.deleteById(id);
		return "delete hotel";
	}

	public HotelEntity singlehotel(String id) {
	    System.out.println("Searching : " + id);
	    return R.findById(id).orElseThrow();
	}
	
}
