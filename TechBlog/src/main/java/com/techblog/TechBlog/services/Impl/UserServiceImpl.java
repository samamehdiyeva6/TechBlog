package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.user.SignInDto;
import com.techblog.TechBlog.model.User;
import com.techblog.TechBlog.repositories.UserRepository;
import com.techblog.TechBlog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean signIn(SignInDto signInDto) {
        User findUser = userRepository.findByEmail(signInDto.getEmail());
        if(findUser != null){
            return false;
        }
        User user = new User();
        user.setName(signInDto.getName());
        user.setSurname(signInDto.getSurname());
        user.setEmail(signInDto.getEmail());
        String password = passwordEncoder.encode(signInDto.getPassword());
        user.setPassword(password);
        user.setEmailToken("jgutfyufcjhc");
        userRepository.save(user);

        return true;
    }

    @Override
    public User findUser(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @Override
    public long getAllUser() {
        return userRepository.findAll().stream().count();
    }
}
