package com.lxy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lxy.entity.Course;
import com.lxy.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmallShardingJdbcApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void addCourse() {

        for (int i = 0; i < 10; i++) {
            courseMapper.insert(Course.builder()
//                    .cid((long) i)
                    .cname("sharding-jdbc")
                    .userId((long) (1000 + i))
                    .cstatus("1")
                    .build());
        }
    }

    @Test
    void queryCourse() {
        List<Course> courses = courseMapper.selectList(new QueryWrapper<Course>().lambda().eq(Course::getCid, 680566112437407744L));
        courses.forEach(System.out::println);
    }



}
