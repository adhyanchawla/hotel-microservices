package com.ratingService.RatingService.services.impl;

import com.ratingService.RatingService.entities.Rating;
import com.ratingService.RatingService.repositories.RatingRepo;
import com.ratingService.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        Rating savedRating = this.ratingRepo.save(rating);
        return savedRating;
    }

    @Override
    public List<Rating> getAll() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllByHotel(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getAllByUser(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }
}
