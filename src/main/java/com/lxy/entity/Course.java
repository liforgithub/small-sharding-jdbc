package com.lxy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lxy
 * @date: 2021/12/22 11:20 下午
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    private Long cid;

    private String cname;

    private Long userId;

    private String cstatus;
}
