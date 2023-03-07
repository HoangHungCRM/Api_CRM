package com.resdii.crm.user.controller;

import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.dto.UserInfoDTO;
import com.resdii.crm.user.service.AuthService;
import com.resdii.ms.common.rest.BaseRestController;
import com.resdii.ms.common.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseRestController {

    private AuthService userService;
    @Autowired
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
    @GetMapping("/user")
    public String getUsername(Authentication authentication, Principal principal){
        System.out.println(authentication.getName());
        System.out.println(principal.getName());
        return "";
    }


    @Autowired
    public void setUserService(AuthService userService) {
        this.userService = userService;
    }


}
