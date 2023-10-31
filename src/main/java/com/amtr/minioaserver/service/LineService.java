package com.amtr.minioaserver.service;

import com.amtr.minioaserver.pojo.Line;

import java.lang.annotation.Retention;
import java.util.List;

public interface LineService {

    List<Line> select();

    boolean insert(Line line);

    void delete(int id);

    void update(Line line);
}
