package com.softsignatureslab.ecommerce.services.user;

import com.softsignatureslab.ecommerce.dto.UserDto;
import com.softsignatureslab.ecommerce.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(UserDto userDto);
}
