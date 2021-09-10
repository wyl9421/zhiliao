package com.zhiliao.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiliao.app.entity.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao extends BaseMapper<Article> {
    boolean add_article(@Param("article") Article article,
                        @Param("name") String name);

    boolean remove_article(Integer at_id);

    boolean edit_article(Article article);

    boolean collect_article(@Param("at_id") Integer at_id,
                            @Param("id") Integer id);

    boolean remove_collect_article(@Param("at_id") Integer at_id,
                                   @Param("id") Integer id);

    boolean like_article(Integer at_id);

    void addCollection(Integer at_id);

    void decreaseCollection(Integer at_id);
}
