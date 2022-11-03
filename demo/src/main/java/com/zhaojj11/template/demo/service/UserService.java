package com.zhaojj11.template.demo.service;

import com.zhaojj11.template.demo.domain.model.User;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @author zhaojj11
 */
public interface UserService {
    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return User
     */
    User getById(@NonNull Long id);

    /**
     * 查询年龄为 age的用户列表
     *
     * @param age 年龄
     * @return 用户列表
     */
    @NonNull
    List<User> listByAge(@NonNull Integer age);

    /**
     * 保存user，id会被更新到user的主键
     *
     * @param user 用户
     * @return 是否保存成功
     */
    boolean save(@NonNull User user);

    /**
     * 删除user
     *
     * @param id user id
     * @return 返回是否删除成功
     */
    boolean remove(@NonNull Long id);

    /**
     * 根据id更新user
     *
     * @param user 待更新的数据
     * @return 是否更新成功
     */
    boolean updateById(User user);
}
