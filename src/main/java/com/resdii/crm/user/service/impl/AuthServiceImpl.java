package com.resdii.crm.user.service.impl;

import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.domain.RolesUsers;
import com.resdii.crm.user.domain.Test;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.*;
import com.resdii.crm.user.repository.RoleRepository;
import com.resdii.crm.user.repository.RoleUserRepository;
import com.resdii.crm.user.repository.UserRepository;
import com.resdii.crm.user.service.AuthService;
import com.resdii.ms.common.utils.JsonUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    public void testDecodeJWT(@RequestHeader String token) {
//        String jwtToken = token.split("\\.")[1];
//
//    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        String passwordmd5 = DigestUtils.md5Hex(loginRequest.getPassword()).toLowerCase();
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + loginRequest.getUsername());
        } else {
            if (bcryptEncoder.matches(passwordmd5, user.getPassword())) {
                Map<String, Object> claims = new HashMap<>();

                String token = jwtTokenUtil.generateToken(userRepository.findByUsername(loginRequest.getUsername()));
                LoginResponseDTO loginResponseDTO =new LoginResponseDTO(token);
                return loginResponseDTO;
            } else {
                throw new UsernameNotFoundException("Mkhau không chính xác " + user.getPassword());
            }
        }
    }

    @Override
    public List<TestDTO> getTestList() {
        List<Test> testList = testRepository.findAll();
        return testMapper.toDest(testList);
    }
    @Override
    public List<RoleUser> getListRoleUser(){
        User user= new User();
        List<RolesUsers> rolesUsersList = roleUserRepository.findByUserId(user.getId());
        return roleUserMapper.toDest(rolesUsersList);
    }
    @Override
    public UserInfoDTO getUserInfo(@RequestHeader(name = "Authorization") String token) throws UnsupportedEncodingException {
        String jwtToken = token.split("\\.")[1];
        String a = new String(Base64.decodeBase64(jwtToken), "UTF-8");
        DecodeJWT details = JsonUtils.parseObject(a, DecodeJWT.class);

        User user =userRepository.findUserById(details.getSub());
        return userInforMapper.toDest(user);
    }


//    @Override
//    public User userInfor(@RequestHeader(name = "Authorization") String token) throws UnsupportedEncodingException {
//        String jwtToken = token.split("\\.")[1];
//        String a = new String(Base64.decodeBase64(jwtToken), "UTF-8");
//        DecodeJWT details = JsonUtils.parseObject(a, DecodeJWT.class);
//        User user =userRepository.findUserById(details.getSub());
//        return user;
//    }
}
