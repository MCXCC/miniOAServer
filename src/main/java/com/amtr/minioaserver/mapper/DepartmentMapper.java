package com.amtr.minioaserver.mapper;

import com.amtr.minioaserver.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> select(Department department);

    @Insert("insert into department(title,create_time,update_time) values (#{title},#{createTime},#{updateTime})")
    void insert(Department department);

    @Delete("delete from department where id=#{id}")
    void delete(int id);

    void update(Department department);
}
