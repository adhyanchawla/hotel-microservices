package com.userservice.UserService.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private int rating;
    private String hotelId;
    private String feedback;
    private String userId;
    private Hotel hotel;
}
