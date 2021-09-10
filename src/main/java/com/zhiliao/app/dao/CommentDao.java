package com.zhiliao.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiliao.app.entity.Article;
import com.zhiliao.app.entity.Comment;
import org.apache.ibatis.annotations.Param;


public interface CommentDao extends BaseMapper<Comment> {
//    boolean add_article_comment(@Param("co_id") Integer co_id,
//                                @Param("at_id") Integer at_id,
//                                 @Param("id") Integer id);
//
//    void article_comment(String co_content);
}

