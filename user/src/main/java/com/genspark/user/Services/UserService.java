package com.genspark.user.Services;

import com.genspark.user.Entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(long id);
    User addNewUser(User user);

}
