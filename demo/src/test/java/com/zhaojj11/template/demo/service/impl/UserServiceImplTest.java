package com.zhaojj11.template.demo.service.impl;

import com.zhaojj11.template.demo.domain.dao.UserDao;
import com.zhaojj11.template.demo.domain.model.User;
import com.zhaojj11.template.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    void getById() {
        Mockito.when(userDao.getById(Mockito.anyLong())).thenReturn(User.builder().id(1L).name("test").age(1).email("test@test.com").build());
        User user = userService.getById(1L);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("test", user.getName());
    }

    @Test
    void listByAge() {
        List<User> mockUsers = new ArrayList<>();
        User user1 = User.builder().id(1L).name("user1").age(1).email("user1@test.com").build();
        User user2 = User.builder().id(2L).name("user2").age(2).email("user2@test.com").build();
        mockUsers.add(user1);
        mockUsers.add(user2);

        Mockito.when(userDao.listByAge(Mockito.anyInt())).thenReturn(mockUsers);
        List<User> users = userService.listByAge(1);
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getName());
        assertEquals("user2", users.get(1).getName());
    }

    @Test
    void save() {
        User user = User.builder().id(1L).name("user").age(1).email("user@test.com").build();
        Mockito.when(userDao.save(ArgumentMatchers.any(User.class))).thenReturn(true);
        boolean save = userService.save(user);
        assertTrue(save);
    }

    @Test
    void remove() {
        Mockito.when(userDao.removeById(Mockito.anyLong())).thenReturn(true);
        boolean remove = userService.remove(1L);
        assertTrue(remove);
    }

    @Test
    void updateById() {
        User user = User.builder().id(1L).name("user").age(1).email("user@test.com").build();
        Mockito.when(userDao.updateById(ArgumentMatchers.any(User.class))).thenReturn(true);
        boolean updated = userService.updateById(user);
        assertTrue(updated);
    }
}