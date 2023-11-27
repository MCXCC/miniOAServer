package com.amtr.minioaserver.controller;

import com.amtr.minioaserver.pojo.Department;
import com.amtr.minioaserver.pojo.Result;
import com.amtr.minioaserver.pojo.User;
import com.amtr.minioaserver.service.DepartmentService;
import com.amtr.minioaserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
