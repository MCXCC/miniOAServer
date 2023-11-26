package com.amtr.minioaserver.mapper;

import com.amtr.minioaserver.pojo.Line;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface LineMapper {
    List<Line> select(Line line);

    @Insert("insert into line(title,create_time,update_time) values (#{title},#{createTime},#{updateTime})")
    void insert(Line line);

    @Delete("delete from line where id=#{id}")
    void delete(int id);

    void update(Line line);
}
