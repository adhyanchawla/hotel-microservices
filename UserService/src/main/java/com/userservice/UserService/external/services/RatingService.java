package com.userservice.UserService.external.services;

import com.userservice.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(Rating rating, @PathVariable String ratingId);

    @DeleteMapping("/ratings/{ratingId)")
    void deleteRating(@PathVariable String ratingId);
}
