package com.ratingService.RatingService.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    private String ratingId;
    private int rating;
    private String hotelId;
    private String feedback;
    private String userId;
    private Hotel hotel;
}
