package com.zhaojj11.template.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("com.zhaojj11.template.demo.domain")
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
