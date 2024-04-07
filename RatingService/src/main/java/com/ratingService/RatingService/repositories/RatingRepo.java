package com.ratingService.RatingService.repositories;

import com.ratingService.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
