package com.hotelservice.HotelService.services;

import com.hotelservice.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getHotels();
    Hotel getHotel(String hotelId);
}
