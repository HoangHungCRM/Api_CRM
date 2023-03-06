package com.resdii.crm.user.controller;


import com.resdii.crm.user.config.JwtTokenUtil;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.dto.LoginResponseDTO;
import com.resdii.crm.user.service.impl.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequestDTO authenticationRequest) throws Exception {
//
////        //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
////
////
//////        final UserDetails userDetails = userDetailsService.loadUserfiByUsername(authenticationRequest.getUsername());
////
////
////        final String token = jwtTokenUtil.generateToken(userDetails);
////
////        return ResponseEntity.ok(new LoginResponseDTO(token));
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
}