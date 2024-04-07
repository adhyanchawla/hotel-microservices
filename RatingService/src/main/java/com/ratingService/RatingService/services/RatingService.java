package com.ratingService.RatingService.services;

import com.ratingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    // create
    Rating createRating(Rating rating);

    // get all ratings
    List<Rating> getAll();

    // get all by hotel id
    List<Rating> getAllByHotel(String hotelId);

    // get all by user id
    List<Rating> getAllByUser(String userId);
}
