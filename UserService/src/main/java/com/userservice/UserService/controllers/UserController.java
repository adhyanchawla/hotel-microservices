package com.userservice.UserService.controllers;

import com.userservice.UserService.entities.User;
import com.userservice.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = this.userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    // creating rating hotel fallback method for circuit breaker
    int retryCount = 1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name ="ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="ratingHotelLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        retryCount++;
        logger.info("Retry Count: {}", retryCount);
        return new ResponseEntity<>(this.userService.getUser(userId), HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        logger.info("Fallback is executed because service is down: ", ex.getMessage());
        User user = User.builder().email("dummy@gmail.com").name("dummy").about("Dummy Account because service is down").build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
