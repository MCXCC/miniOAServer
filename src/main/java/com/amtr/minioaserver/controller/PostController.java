package com.amtr.minioaserver.controller;

import com.amtr.minioaserver.pojo.Department;
import com.amtr.minioaserver.pojo.Post;
import com.amtr.minioaserver.pojo.Result;
import com.amtr.minioaserver.service.DepartmentService;
import com.amtr.minioaserver.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // 允许来自指定域名的跨域请求
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public Result select(@RequestBody(required = false) Post post) {
        log.info("查询岗位");
        List<Post> list = postService.select(post);
        return Result.success(list);
    }

    @PostMapping
    public Result insert(@RequestBody Post post) {
        log.info("创建新岗位:{}", post);
        // 判断岗位是否存在
        if (postService.insert(post))
            return Result.success();
        else return Result.failMsg("岗位已存在");
    }

    @DeleteMapping
    public Result delete(@RequestParam("id") int id) {
        log.info("根据id删除岗位：{}", id);
        postService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Post post) {
        log.info("更新岗位信息：{}", post);
        postService.update(post);
        return Result.success();
    }
}
