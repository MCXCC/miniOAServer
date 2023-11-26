package com.amtr.minioaserver.service.impl;

import com.amtr.minioaserver.mapper.DepartmentMapper;
import com.amtr.minioaserver.pojo.Department;
import com.amtr.minioaserver.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public List<Department> select(Department department) {
        return departmentMapper.select(department);
    }

    @Override
    public boolean insert(Department department) {
        // 判断是否部门名称是否已存在
        if (!departmentMapper.select(new Department(department.getTitle())).isEmpty())
            // 如果部门存在直接返回
            return false;
        // 设置创建时间和更新时间
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        // 创建部门
        departmentMapper.insert(department);
        return true;
    }

    @Override
    public void delete(int id) {
        departmentMapper.delete(id);
    }

    @Override
    public void update(Department department) {
        // 设置更新时间
        department.setUpdateTime(LocalDateTime.now());
        departmentMapper.update(department);
    }
}
