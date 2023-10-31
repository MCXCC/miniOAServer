package com.amtr.minioaserver.mapper;

import com.amtr.minioaserver.pojo.Line;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface LineMapper {
    @Select("select * from line")
    List<Line> select();

    @Select("select * from line where title=#{title}")
    List<Line> selectByTitle(String title);

    @Insert("insert into line(title,create_time,update_time) values (#{title},#{createTime},#{updateTime})")
    void insert(Line line);

    @Delete("delete from line where id=#{id}")
    void delete(int id);

    @Update("update line set title=#{title},director_id=#{directorId},update_time=#{updateTime} where id=#{id}")
    void update(Line line);
}
