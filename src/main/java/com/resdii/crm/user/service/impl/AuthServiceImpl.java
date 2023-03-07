package com.resdii.crm.user.service.impl;

import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.domain.Test;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.*;
import com.resdii.crm.user.repository.UserRepository;
import com.resdii.crm.user.service.AuthService;
import liquibase.pro.packaged.L;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername());
//        String passwordEncoded = bcryptEncoder.encode(loginRequest.getPassword());
//        String paswordmd5 = loginRequest.getPassword();
//        String paswordmd5 = "042acd3e4652355c873915a09df728d1";
        String passwordmd5 = DigestUtils.md5Hex(loginRequest.getPassword()).toLowerCase();
//        System.out.printf(paswordmd5);
        //throw new UsernamNotFoundException(passwordEncoded);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + loginRequest.getUsername());
        } else {

            if (bcryptEncoder.matches(passwordmd5, user.getPassword())) {
                Map<String, Object> claims = new HashMap<>();
                LoginResponseDTO loginResponseDTO =new LoginResponseDTO();
                String token = jwtTokenUtil.generateToken(userRepository.findByUsername(loginRequest.getUsername()));
//              String token = jwtTokenUtil.doGenerateToken(claims, user.getUsername());
                loginResponseDTO.setToken(token);
                return loginResponseDTO;
                //throw new UsernameNotFoundException(passwordEncoded);
//                LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
//                String token = jwtTokenUtil.generateToken(userRepository.findByUsername(loginRequest.getUsername()));
//                loginResponseDTO.getToken(token);
//                return loginResponseDTO;
//                UserInfoDTO userInfo = new UserInfoDTO();
//                userInfo.setFullName(user.getUsername());
//                return userInfo;
            } else {
                throw new UsernameNotFoundException("Mkhau không chính xác " + user.getPassword());
            }

        }

//        if(!"admin".equals(loginRequest.getUsername()) || !"admin".equals(loginRequest.getPassword())){
//            throw new InvalidRequestException("Account is invalid");
//        }
//        UserInfoDTO userInfo = new UserInfoDTO();
//        userInfo.setFullName("Administrator");
//        return userInfo;
    }

    @Override
    public List<TestDTO> getTestList() {
        List<Test> testList = testRepository.findAll();
        return testMapper.toDest(testList);
    }


}
