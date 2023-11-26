package com.amtr.minioaserver.mapper;

import com.amtr.minioaserver.pojo.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> select(Post post);

    @Insert("insert into post(title,create_time,update_time) values (#{title},#{createTime},#{updateTime})")
    void insert(Post post);

    @Delete("delete from post where id=#{id}")
    void delete(int id);

    void update(Post post);
}
