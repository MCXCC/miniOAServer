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
        if (!lineMapper.select(new Line(line.getTitle())).isEmpty())
            // 如果线路存在直接返回
            return false;
        // 设置创建时间和更新时间
        line.setCreateTime(LocalDateTime.now());
        line.setUpdateTime(LocalDateTime.now());
        // 创建线路
        lineMapper.insert(line);
        return true;
    }

    @Override
    public void delete(int id) {
        lineMapper.delete(id);
    }

    @Override
    public void update(Line line) {
        // 设置更新时间
        line.setUpdateTime(LocalDateTime.now());
        lineMapper.update(line);
    }
}
