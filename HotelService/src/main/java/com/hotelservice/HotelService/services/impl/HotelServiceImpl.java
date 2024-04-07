package com.hotelservice.HotelService.services.impl;

import com.hotelservice.HotelService.entities.Hotel;
import com.hotelservice.HotelService.repositories.HotelRepo;
import com.hotelservice.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        Hotel savedHotel = this.hotelRepo.save(hotel);
        return savedHotel;
    }

    @Override
    public List<Hotel> getHotels() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(()-> new RuntimeException("Hotel does not exist!!"));
        return hotel;
    }
}
