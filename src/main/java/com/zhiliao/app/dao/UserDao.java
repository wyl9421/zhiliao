package com.zhiliao.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiliao.app.entity.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao extends BaseMapper<User> {

    User login(String principal);

    int register(User user);

    int hasexisted(@Param("name") String name,
                   @Param("password") String password);

    boolean destory(Integer id);

    boolean update(User user);

    boolean collect_article(@Param("at_id") Integer at_id, @Param("id") Integer id);

    boolean remove_collect_article(@Param("at_id") Integer at_id,
                                   @Param("id") Integer id);
}

