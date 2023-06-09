package com.nonIt.GameOn.authentication.impl;

import com.nonIt.GameOn.authentication.AuthController;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.security.jwt.JwtRequest;
import com.nonIt.GameOn.security.jwt.JwtResponse;
import com.nonIt.GameOn.security.jwt.JwtUtils;
import com.nonIt.GameOn.security.service.impl.UserSecurityDetailsImpl;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.createdto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    private final UserService userService;


    @Override
    public ResponseEntity<?> authenticateUser(JwtRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserSecurityDetailsImpl userDetails = (UserSecurityDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @Override
    public ResponseEntity<?> registerUser(UserDto userSignUpDto) {
        if (userRepository.existsByUsername(userSignUpDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(userSignUpDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        userService.createUser(userSignUpDto);

        return ResponseEntity.ok("User registered successfully!");
    }
}
