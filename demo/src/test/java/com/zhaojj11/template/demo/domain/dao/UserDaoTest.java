package com.zhaojj11.template.demo.domain.dao;

import com.zhaojj11.template.demo.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles(value = "dev")
@MapperScan("com.zhaojj11.template.demo.domain")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testFindById() {
        User user = userDao.getById(1);
        assertNotNull(user);
        System.out.println(user);
    }
}