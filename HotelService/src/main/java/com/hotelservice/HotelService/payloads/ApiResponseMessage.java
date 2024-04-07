package com.hotelservice.HotelService.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseMessage {
    private String message;
    private HttpStatus status;
}
