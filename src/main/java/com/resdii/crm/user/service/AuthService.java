package com.resdii.crm.user.service;

import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.*;
import com.resdii.crm.user.mapper.UserInforMapper;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface AuthService {
    /**
     * Dang nhap he thong
     * @return
     */
    LoginResponseDTO login(LoginRequestDTO loginRequest);

    /**
     * Demo truy van du lieu tu Database
     * @return
     */
    List<TestDTO> getTestList();

    List<RoleUser> getListRoleUser();

    UserInfoDTO getUserInfo(@RequestHeader(name = "Authorization") String token) throws UnsupportedEncodingException;

}
