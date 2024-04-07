package com.ratingService.RatingService.controllers;

import com.ratingService.RatingService.entities.Rating;
import com.ratingService.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(this.ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return new ResponseEntity<>(this.ratingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId) {
        return new ResponseEntity<>(this.ratingService.getAllByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId) {
        return new ResponseEntity<>(this.ratingService.getAllByHotel(hotelId), HttpStatus.OK);
    }
}
