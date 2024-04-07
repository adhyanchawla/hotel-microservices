package com.hotelservice.HotelService.controllers;

import com.hotelservice.HotelService.entities.Hotel;
import com.hotelservice.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(this.hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return new ResponseEntity<>(this.hotelService.getHotel(hotelId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        return new ResponseEntity<>(this.hotelService.getHotels(), HttpStatus.OK);
    }
}
