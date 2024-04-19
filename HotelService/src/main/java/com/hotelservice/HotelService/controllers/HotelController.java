package com.hotelservice.HotelService.controllers;

import com.hotelservice.HotelService.entities.Hotel;
import com.hotelservice.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PreAuthorize("hasAuthority('Admin)")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(this.hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        return new ResponseEntity<>(this.hotelService.getHotel(hotelId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin)")
    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        return new ResponseEntity<>(this.hotelService.getHotels(), HttpStatus.OK);
    }
}
