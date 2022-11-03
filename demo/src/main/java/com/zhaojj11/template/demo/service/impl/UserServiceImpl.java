package com.zhaojj11.template.demo.service.impl;

import com.zhaojj11.template.demo.domain.dao.UserDao;
import com.zhaojj11.template.demo.domain.model.User;
import com.zhaojj11.template.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaojj11
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User getById(@NonNull Long id) {
        return userDao.getById(id);
    }

    @Override
    public @NonNull List<User> listByAge(@NonNull Integer age) {
        return userDao.listByAge(age);
    }

    @Override
    public boolean save(@NonNull User user) {
        return userDao.save(user);
    }

    @Override
    public boolean remove(@NonNull Long id) {
        return userDao.removeById(id);
    }

    @Override
    public boolean updateById(@NonNull User user) {
        return userDao.updateById(user);
    }
}
