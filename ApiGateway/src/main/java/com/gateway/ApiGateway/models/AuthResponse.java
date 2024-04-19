package com.gateway.ApiGateway.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Getter
@Setter
@Data
public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expireAt;
    private Collection<String> authorities;
}
