package com.gunwoda.test1127;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/input")
    public String saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return "success";
    }
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/")
    public List<UserDTO> findAll() {
        return userService.findAllUsers();
    }
}
