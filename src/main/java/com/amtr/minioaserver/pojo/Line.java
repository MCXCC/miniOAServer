package com.amtr.minioaserver.pojo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 线路实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Line {
    /**
     * ID
     */
    private Integer id;
    /**
     * 线路名
     */
    private String title;
    /**
     * 分管主任ID
     */
    private User director;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Line(String title) {
        this.title = title;
    }
}
