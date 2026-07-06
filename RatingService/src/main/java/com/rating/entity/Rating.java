package com.rating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "Rating")
@Data
public class Rating {
	@Id
	private String ratingId;
	 private String userId;
	 private String hotelId;
	 private int ratings;
	 private String feedback;
}
