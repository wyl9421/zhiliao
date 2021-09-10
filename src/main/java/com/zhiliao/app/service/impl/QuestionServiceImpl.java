package com.zhiliao.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiliao.app.dao.UserDao;
import com.zhiliao.app.entity.Question;
import com.zhiliao.app.dao.QuestionDao;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.QuestionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionDao, Question> implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Override
    public boolean add_question(Question question) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.questionDao.add_question(question,user.getName());
    }

    @Override
    public boolean remove_question(Integer qs_id) {
        return this.questionDao.remove_question(qs_id);
    }

    @Override
    public boolean collect_question(Integer qs_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.questionDao.collect_question(qs_id,user.getId());
    }

    @Override
    public boolean remove_collect_question(Integer qs_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
     return this.questionDao.remove_collect_question(qs_id,user.getId());
    }

    @Override
    public boolean like_question(Integer qs_id) {
        return this.questionDao.like_question(qs_id);
    }
}
