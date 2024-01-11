package com.softsignatureslab.ecommerce.services.user;

import com.softsignatureslab.ecommerce.dto.UserDto;
import com.softsignatureslab.ecommerce.entities.User;
import com.softsignatureslab.ecommerce.exceptions.UserAlreadyExistException;
import com.softsignatureslab.ecommerce.repositories.UserRepository;
import com.softsignatureslab.ecommerce.utilities.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistException("User already exists");
        }

        User userInfo = User.builder()
                .lastName(userDto.getLastName())
                .phoneNumber(userDto.getPhoneNumber())
                .firstName(userDto.getFirstName())
                .email(userDto.getEmail())
                .password(PasswordUtil.hashPassword(userDto.getPassword()))
                .build();

        return userRepository.save(userInfo);
    }
}
