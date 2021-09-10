package com.zhiliao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiliao.app.entity.Answer;
import com.zhiliao.app.entity.Article;
import com.zhiliao.app.entity.Question;
import com.zhiliao.app.entity.User;

public interface UserService extends IService<User> {

    User login(String principal);

    boolean register(User user);

    boolean destory(Integer id);

    boolean updateUserMessage(User user);

    boolean publish_article(Article article);

    boolean remove_article(Integer at_id);

    boolean remove_article(Article article);

    boolean publish_question(Question question);

    boolean remove_question(Integer qs_id);

    boolean add_answer(Answer answer);

    boolean remove_answer(Integer an_id);

    boolean collect_article(Integer at_id);

    boolean remove_collect_article(Integer at_id);
}

