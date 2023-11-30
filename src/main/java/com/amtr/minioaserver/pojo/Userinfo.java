package com.amtr.minioaserver.pojo;

import lombok.*;

/**
 * 用户信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Userinfo {
    /**
     * 工号
     */
    private String workNumber;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * token
     */
    private String token;
}
