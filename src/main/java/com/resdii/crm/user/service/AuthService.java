package com.resdii.crm.user.service;

import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.dto.TestDTO;
import com.resdii.crm.user.dto.TokenDTO;

import java.util.List;

public interface AuthService {
    /**
     * Dang nhap he thong
     * @return
     */
    TokenDTO login(LoginRequestDTO loginRequest);

    /**
     * Demo truy van du lieu tu Database
     * @return
     */
    List<TestDTO> getTestList();
}
