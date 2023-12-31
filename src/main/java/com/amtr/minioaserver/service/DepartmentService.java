package com.amtr.minioaserver.service;

import com.amtr.minioaserver.pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> select(Department department);

    boolean insert(Department department);

    void delete(int id);

    void update(Department department);
}
