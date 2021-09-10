package com.zhiliao.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiliao.app.entity.Answer;
import org.apache.ibatis.annotations.Param;

public interface AnswerDao extends BaseMapper<Answer> {

    boolean add_answer(@Param("answer") Answer answer,
                       @Param("an_name") String an_name);

    boolean remove_answer(Integer an_id);
}

