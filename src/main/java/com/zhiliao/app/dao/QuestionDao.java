package com.zhiliao.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiliao.app.entity.Question;
import org.apache.ibatis.annotations.Param;

public interface QuestionDao extends BaseMapper<Question> {


    boolean add_question(@Param("question") Question question,
                         @Param("author") String author);

    boolean remove_question(Integer qs_id);

    boolean collect_question(@Param("qs_id") Integer qs_id,
                             @Param("id") Integer id);

    boolean remove_collect_question(@Param("qs_id") Integer qs_id,
                                    @Param("id") Integer id);

    boolean like_question(Integer qs_id);
}

