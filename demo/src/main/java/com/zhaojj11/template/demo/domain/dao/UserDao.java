package com.zhaojj11.template.demo.domain.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaojj11.template.demo.domain.model.User;
import com.zhaojj11.template.demo.domain.model.User.UserMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * user mapper
 *
 * @author zhaojj11
 */
@Repository
public class UserDao extends ServiceImpl<UserMapper, User> {
    public List<User> listByAge(@NonNull Integer age) {
        List<User> users = getBaseMapper().selectList(
                new LambdaQueryWrapper<User>()
                        .eq(User::getAge, age)
        );
        return CollectionUtils.isEmpty(users) ? new ArrayList<>() : users;
    }
}
