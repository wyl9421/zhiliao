package com.zhiliao.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiliao.app.dao.AnswerDao;
import com.zhiliao.app.dao.ArticleDao;
import com.zhiliao.app.dao.QuestionDao;
import com.zhiliao.app.dao.UserDao;
import com.zhiliao.app.entity.Answer;
import com.zhiliao.app.entity.Article;
import com.zhiliao.app.entity.Question;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private ArticleDao articleDao;
    @Resource
    private QuestionDao questionDao;
    @Resource
    private AnswerDao answerDao;
    @Override
    public User login(String principal) {
        return userDao.login(principal);
    }

    @Override
    public boolean register(User user) {
        int flag=userDao.hasexisted(user.getName(),user.getPassword());
        if(flag>0){
            return false;
        }else{
            return userDao.register(user)>0;
        }
    }

    @Override
    public boolean destory(Integer id) {
        return userDao.destory(id);
    }

    @Override
    public boolean updateUserMessage(User user) {
        return this.userDao.update(user);
    }

    @Override
    public boolean publish_article(Article article) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return articleDao.add_article(article,user.getName());
    }

    @Override
    public boolean remove_article(Integer at_id) {
        return articleDao.remove_article(at_id);
    }

    @Override
    public boolean remove_article(Article article) {
        return articleDao.edit_article(article);
    }

    @Override
    public boolean publish_question(Question question) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.questionDao.add_question(question,user.getName());
    }

    @Override
    public boolean remove_question(Integer qs_id) {
        return this.questionDao.remove_question(qs_id);
    }

    @Override
    public boolean add_answer(Answer answer) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return answerDao.add_answer(answer,user.getName());
    }

    @Override
    public boolean remove_answer(Integer an_id) {
        return this.answerDao.remove_answer(an_id);
    }

    @Override
    public boolean collect_article(Integer at_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.userDao.remove_collect_article(at_id,user.getId());
    }

    @Override
    public boolean remove_collect_article(Integer at_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.userDao.remove_collect_article(at_id,user.getId());
    }
}

