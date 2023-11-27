package com.amtr.minioaserver.service;

import com.amtr.minioaserver.pojo.User;

import java.util.List;

public interface UserService {
    List<User> select(User user);

    boolean insert(User user);

    void delete(int id);

    void update(User user);
}
