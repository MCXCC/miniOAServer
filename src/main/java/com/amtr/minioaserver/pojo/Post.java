package com.amtr.minioaserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    /**
     * id
     */
    private Integer id;
    /**
     * 岗位名称
     */
    private String title;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Post(String title) {
        this.title = title;
    }
}
