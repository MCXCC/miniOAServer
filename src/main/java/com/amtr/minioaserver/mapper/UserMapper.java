package com.amtr.minioaserver.mapper;

import com.amtr.minioaserver.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.amtr.minioaserver.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> select(User user);

    @Insert("insert into user(work_number,password,post_id,department_id,line_id,create_time,update_time) values (#{workNumber},#{password},#{postId},#{departmentId},#{lineId},#{createTime},#{updateTime})")
    void insert(User user);

    @Delete("delete from user where id=#{id}")
    void delete(int id);

    void update(User user);
}
