package com.techblog.TechBlog.services;

import com.techblog.TechBlog.dtos.user.SignInDto;
import com.techblog.TechBlog.model.User;

public interface UserService {
    boolean signIn(SignInDto signInDto);
    User findUser(String email);

    long getAllUser();
}
