package com.amtr.minioaserver.service.impl;

import com.amtr.minioaserver.mapper.LineMapper;
import com.amtr.minioaserver.pojo.Line;
import com.amtr.minioaserver.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private LineMapper lineMapper;

    @Override
    public List<Line> select(Line line) {
        return lineMapper.select(line);
    }

    @Override
    public boolean insert(Line line) {
        // 判断是否线路名称是否已存在
        if (!lineMapper.select(line).isEmpty())
            return false;
        line.setCreateTime(LocalDateTime.now());
        line.setUpdateTime(LocalDateTime.now());
        lineMapper.insert(line);
        return true;
    }

    @Override
    public void delete(int id) {
        lineMapper.delete(id);
    }

    @Override
    public void update(Line line) {
        line.setUpdateTime(LocalDateTime.now());
        lineMapper.update(line);
    }
}
