package com.amtr.minioaserver.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * 工号
     */
    private String workNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 岗位
     */
    private Post post;
    /**
     * 部门id
     */
    private Department department;
    /**
     * 线路id
     */
    private Line line;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public User(String workNumber) {
        this.workNumber = workNumber;
    }
}
