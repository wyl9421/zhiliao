package com.zhiliao.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiliao.app.dao.AnswerDao;
import com.zhiliao.app.dao.ArticleDao;
import com.zhiliao.app.entity.Answer;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.AnswerService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("answerService")
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, Answer> implements AnswerService {
    @Resource
    private AnswerDao answerDao;

    @Override
    public boolean add_answer(Answer answer) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.answerDao.add_answer(answer,user.getName());
    }
    @Override
    public boolean remove_answer(Integer an_id){
        return this.answerDao.remove_answer(an_id);
    }
}

