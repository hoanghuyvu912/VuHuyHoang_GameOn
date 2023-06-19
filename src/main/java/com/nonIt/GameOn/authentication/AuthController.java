package com.nonIt.GameOn.authentication;

import com.nonIt.GameOn.security.jwt.JwtRequest;
import com.nonIt.GameOn.service.createdto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Validated @RequestBody JwtRequest loginRequest);


    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userSignUpDto);
}
