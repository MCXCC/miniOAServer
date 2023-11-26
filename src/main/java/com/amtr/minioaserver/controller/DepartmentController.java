package com.amtr.minioaserver.controller;

import com.amtr.minioaserver.pojo.Department;
import com.amtr.minioaserver.pojo.Result;
import com.amtr.minioaserver.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // 允许来自指定域名的跨域请求
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result select(@RequestBody(required = false) Department department) {
        log.info("查询部门");
        List<Department> list = departmentService.select(department);
        return Result.success(list);
    }

    @PostMapping
    public Result insert(@RequestBody Department department) {
        log.info("创建新部门:{}", department);
        // 判断部门是否存在
        if (departmentService.insert(department))
            return Result.success();
        else return Result.failMsg("部门已存在");
    }

    @DeleteMapping
    public Result delete(@RequestParam("id") int id) {
        log.info("根据id删除部门：{}", id);
        departmentService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Department department) {
        log.info("更新部门信息：{}", department);
        departmentService.update(department);
        return Result.success();
    }
}
