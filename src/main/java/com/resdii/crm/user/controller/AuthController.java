package com.resdii.crm.user.controller;

import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.DecodeJWT;
import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.mapper.UserInforMapper;
import com.resdii.crm.user.repository.UserRepository;
import com.resdii.crm.user.service.AuthService;
import com.resdii.ms.common.rest.BaseRestController;
import com.resdii.ms.common.utils.JsonUtils;
import com.resdii.ms.common.utils.RestUtils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseRestController {

    private UserRepository userRepository;

    private AuthService userService;

    private JwtTokenUtil jwtTokenUtil;

    /**
     * Dang nhap
     * @return
     */

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequest) {
        return RestUtils.responseOk(userService.login(loginRequest));
    }

    @GetMapping("/test")
    public ResponseEntity getTestList() {
        return RestUtils.responseOk(userService.getTestList());
    }
    @GetMapping(value = "/userinfo",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity userinfo(@RequestHeader(name = "Authorization") String token) throws UnsupportedEncodingException {
    return RestUtils.responseOk(userService.getUserInfo(token));
    }

    @GetMapping("/role")
    public ResponseEntity getListRoleUser(){
        return RestUtils.responseOk(userService.getListRoleUser());
    }
    @Autowired
    public void setUserService(AuthService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
}
