package com.amtr.minioaserver.service.impl;

import com.amtr.minioaserver.mapper.PostMapper;
import com.amtr.minioaserver.pojo.Post;
import com.amtr.minioaserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;


    @Override
    public List<Post> select(Post post) {
        return postMapper.select(post);
    }

    @Override
    public boolean insert(Post post) {
        // 判断是否岗位名称是否已存在
        if (!postMapper.select(new Post(post.getTitle())).isEmpty())
            // 如果岗位存在直接返回
            return false;
        // 设置创建时间和更新时间
        post.setCreateTime(LocalDateTime.now());
        post.setUpdateTime(LocalDateTime.now());
        // 创建岗位
        postMapper.insert(post);
        return true;
    }

    @Override
    public void delete(int id) {
        postMapper.delete(id);
    }

    @Override
    public void update(Post post) {
        // 设置更新时间
        post.setUpdateTime(LocalDateTime.now());
        postMapper.update(post);
    }
}
