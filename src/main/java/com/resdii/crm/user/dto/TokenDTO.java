package com.resdii.crm.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {
    private String accessToken;
    private String refreshToken;

    public void getAccessToken(String token) {
    }
}
