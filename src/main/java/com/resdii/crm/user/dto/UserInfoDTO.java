package com.resdii.crm.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDTO{
    private String username;
    private String password;

    public void setId(String id) {
    }
}
