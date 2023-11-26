package com.amtr.minioaserver.service;

import com.amtr.minioaserver.pojo.Post;

import java.util.List;

public interface PostService {
    List<Post> select(Post post);

    boolean insert(Post post);

    void delete(int id);

    void update(Post post);
}
