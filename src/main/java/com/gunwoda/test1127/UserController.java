package com.gunwoda.test1127;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/input")
    public String saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return "success";
    }
    @GetMapping("/findall")
    public List<UserDTO> findAll() {
        return userService.findAllUsers();
    }
}
