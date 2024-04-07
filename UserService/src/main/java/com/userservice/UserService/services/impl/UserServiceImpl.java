package com.userservice.UserService.services.impl;

import com.userservice.UserService.entities.Hotel;
import com.userservice.UserService.entities.Rating;
import com.userservice.UserService.entities.User;
import com.userservice.UserService.exceptions.ResourceNotFoundException;
import com.userservice.UserService.external.services.HotelService;
import com.userservice.UserService.repositories.UserRepo;
import com.userservice.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public User createUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        User createdUser = this.userRepo.save(user);
        return createdUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        // implement rating service call using rest template
        users = users.stream().map((user)->{
            ArrayList ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
            user.setRatings(ratings);
            return user;
        }).collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User does not exist!!"));
        // fetch user ratings
        Rating[] ratingsList = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//        http://localhost:8082/hotels
        List<Rating>ratings = Arrays.stream(ratingsList).collect(Collectors.toList());
        ratings = ratings.stream().map((rating) -> {
//            ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = this.hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        logger.info(ratingsList.toString());
        user.setRatings(ratings);
        return user;
    }
}
