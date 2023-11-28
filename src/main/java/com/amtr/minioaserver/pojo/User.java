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
     * 岗位id
     */
    private Integer postId;
    /**
     * 部门id
     */
    private Integer departmentId;
    /**
     * 线路id
     */
    private Integer lineId;
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

    public User(String workNumber, Integer postId, Integer departmentId, Integer lineId) {
        this.workNumber = workNumber;
        this.postId = postId;
        this.departmentId = departmentId;
        this.lineId = lineId;
    }
}
