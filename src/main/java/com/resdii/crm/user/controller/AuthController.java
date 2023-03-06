package com.resdii.crm.user.controller;

import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.service.AuthService;
import com.resdii.ms.common.rest.BaseRestController;
import com.resdii.ms.common.utils.RestUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    @Autowired
    public void setUserService(AuthService userService) {
        this.userService = userService;
    }


}
