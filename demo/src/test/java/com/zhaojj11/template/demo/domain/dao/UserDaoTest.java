package com.zhaojj11.template.demo.domain.dao;

import com.zhaojj11.template.demo.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles(value = "test")
@MapperScan("com.zhaojj11.template.demo.domain")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testListByAge() {
        List<User> users = userDao.listByAge(18);
        assertNotNull(users);
        assertEquals(1, users.size());
    }
}