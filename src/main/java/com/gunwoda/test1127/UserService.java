package com.gunwoda.test1127;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void save(UserDTO userDTO) {
        try {
            User user = User.builder().
                    username(userDTO.getUsername()).
                    password(userDTO.getPassword()).
                    email(userDTO.getEmail()).
                    phonenumber(userDTO.getPhonenumber()).
                    build();
            userRepository.save(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public UserDTO findUserById(long id) {
        User user = userRepository.findById((int) id).orElse(null);
        if (user == null) {
            return null; // user가 없을 경우 null 반환
        }
        // DTO로 변환
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhonenumber(user.getPhonenumber());

        return userDTO;
    }
    public List<UserDTO> findAllUsers() {
        try{
            List<UserDTO> userDTOs = new ArrayList<>();
            List<User> users = userRepository.findAll();
            for (User user : users) {
                long id = user.getId();
                userDTOs.add(findUserById(id));
            }
            return userDTOs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
