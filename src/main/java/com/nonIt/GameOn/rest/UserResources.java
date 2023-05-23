package com.nonIt.GameOn.rest;

import com.nonIt.GameOn.entity.Gender;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.service.UserService;
import com.nonIt.GameOn.service.dto.UserDto;
import com.nonIt.GameOn.service.restDto.UserRestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/first-name")
    public ResponseEntity<List<UserRestDto>> getByFirstNameContaining(@RequestParam("firstName") String firstName) {
        return ResponseEntity.ok(userService.findByFirstNameContaining(firstName));
    }

    @GetMapping("/last-name")
    public ResponseEntity<List<UserRestDto>> getByLastNameContaining(@RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(userService.findByLastNameContaining(lastName));
    }

    @GetMapping("/email")
    public ResponseEntity<List<UserRestDto>> getByEmailContaining(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.findByEmailContaining(email));
    }

    @GetMapping("/tel")
    public ResponseEntity<List<UserRestDto>> getByTelContaining(@RequestParam("tel") String tel) {
        return ResponseEntity.ok(userService.findByTelContaining(tel));
    }

    @GetMapping("/address")
    public ResponseEntity<List<UserRestDto>> getByAddressContaining(@RequestParam("address") String address) {
        return ResponseEntity.ok(userService.findByAddressContaining(address));
    }

    @GetMapping("/dob-after")
    public ResponseEntity<List<UserRestDto>> getByDobAfter(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(userService.findByDobAfter(date));
    }

    @GetMapping("/dob-before")
    public ResponseEntity<List<UserRestDto>> getByDobBefore(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(userService.findByDobBefore(date));
    }

    @GetMapping("/balance-greater-than")
    public ResponseEntity<List<UserRestDto>> getByBalanceGreaterThan(@RequestParam("balance") Double balance) {
        return ResponseEntity.ok(userService.findByBalanceGreaterThan(balance));
    }

    @GetMapping("/balance-less-than")
    public ResponseEntity<List<UserRestDto>> getByBalanceLessThan(@RequestParam("balance") Double balance) {
        return ResponseEntity.ok(userService.findByBalanceLessThan(balance));
    }

    @GetMapping("/active-true")
    public ResponseEntity<List<UserRestDto>> getByActiveTrue() {
        return ResponseEntity.ok(userService.findByActiveTrue());
    }

    @GetMapping("/active-false")
    public ResponseEntity<List<UserRestDto>> getByActiveFalse() {
        return ResponseEntity.ok(userService.findByActiveFalse());
    }
}
