package com.zhiliao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiliao.app.entity.Article;

/**
 * (Article)表服务接口
 *
 * @author tww
 * @since 2021-09-06 09:59:14
 */
public interface ArticleService extends IService<Article> {

    boolean add_article(Article article);

    boolean remove_article(Integer at_id);

    boolean edit_article(Article article);

    boolean collect_article(Integer at_id);

    boolean remove_collect_article(Integer at_id);

    boolean like_article(Integer at_id);
}

