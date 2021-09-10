package com.zhiliao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiliao.app.entity.Answer;

/**
 * (Answer)表服务接口
 *
 * @author tww
 * @since 2021-09-06 15:42:02
 */
public interface AnswerService extends IService<Answer> {

    boolean add_answer(Answer answer);

    boolean remove_answer(Integer an_id);
}

