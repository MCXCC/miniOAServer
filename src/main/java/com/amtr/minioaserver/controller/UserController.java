package com.amtr.minioaserver.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.amtr.minioaserver.pojo.Result;
import com.amtr.minioaserver.pojo.User;
import com.amtr.minioaserver.pojo.Userinfo;
import com.amtr.minioaserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // 允许来自指定域名的跨域请求
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result select(@RequestBody(required = false) User user) {
        log.info("查询用户");
        List<User> list = userService.select(user);
        for (User user1 : list) {
            System.out.println(user1);
            System.out.println(user1.getLine());
        }
        return Result.success(list);
    }

    @PostMapping
    public Result insert(@RequestBody User user) {
        log.info("创建新用户:{}", user);
        // 判断部门是否存在
        if (userService.insert(user))
            return Result.success();
        else return Result.failMsg("部门已存在");
    }

    @DeleteMapping
    public Result delete(@RequestParam("id") int id) {
        log.info("根据id删除用户：{}", id);
        userService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("更新用户信息：{}", user);
        userService.update(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登录：{}", user);
        // 非空判断
        if (user.getWorkNumber().isEmpty() || user.getPassword().isEmpty()) {
            return Result.failMsg("用户名或密码为空!");
        }
        List<User> us = userService.select(user);
        if (us.isEmpty()) {
            return Result.failMsg("查询不到该用户!");
        }
        User u = us.get(0);
        if (!Objects.equals(u.getPassword(), user.getPassword())) {
            return Result.failMsg("密码错误!");
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", u.getId());
        map.put("work_number", u.getWorkNumber());
        map.put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        String jwt = JWTUtil.createToken(map, "5531".getBytes());
        Userinfo userinfo = new Userinfo(u.getWorkNumber(), u.getName(), u.getAvatarUrl(), jwt);
        System.out.println("jwt = " + jwt);
        boolean right = JWTUtil.verify(jwt, "5531".getBytes());
        System.out.println("right = " + right);
        final JWT jwt0 = JWTUtil.parseToken(jwt);
        Object load = jwt0.getPayload("work_number");
        System.out.println("load = " + load);
        return Result.success(userinfo);
    }
}
