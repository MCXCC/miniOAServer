package com.amtr.minioaserver.service.impl;

import com.amtr.minioaserver.mapper.UserMapper;
import com.amtr.minioaserver.pojo.User;
import com.amtr.minioaserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> select(User user) {
        return userMapper.select(user);
    }

    @Override
    public boolean insert(User user) {
        // 判断是否工号是否已存在
        if (!userMapper.select(new User(user.getWorkNumber())).isEmpty())
            // 如果工号存在直接返回
            return false;
        // 设置默认密码为123456
        user.setPassword("123456");
        // 设置创建时间和更新时间
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        // 创建员工
        userMapper.insert(user);
        return true;
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        // 设置更新时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
