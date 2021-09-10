package com.zhiliao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiliao.app.entity.Question;


public interface QuestionService extends IService<Question> {

    boolean add_question(Question question);

    boolean remove_question(Integer qs_id);

    boolean collect_question(Integer qs_id);

    boolean remove_collect_question(Integer qs_id);

    boolean like_question(Integer qs_id);
}
