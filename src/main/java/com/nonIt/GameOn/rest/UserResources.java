package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserResources {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserRestDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserRestDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserRestDto> getUserById(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserRestDto> updateUserById(@PathVariable("userId") Integer userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/gender")
    public ResponseEntity<List<UserRestDto>> getByGender(@RequestParam("string")Gender gender) {
        return ResponseEntity.ok(userService.findByGender(gender));
    }
}
