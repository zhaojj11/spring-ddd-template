package com.zhaojj11.template.demo.domain.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaojj11.template.demo.domain.model.User;
import com.zhaojj11.template.demo.domain.model.User.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * user mapper
 *
 * @author zhaojj11
 */
@Repository
public class UserDao extends ServiceImpl<UserMapper, User> {
}
