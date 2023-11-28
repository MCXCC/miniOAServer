package com.amtr.minioaserver.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    /**
     * id
     */
    private Integer id;
    /**
     * 部门名称
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

    public Department(String title) {
        this.title = title;
    }
}
