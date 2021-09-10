package com.zhiliao.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiliao.app.dao.ArticleDao;
import com.zhiliao.app.entity.Article;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    @Override
    public boolean add_article(Article article) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return this.articleDao.add_article(article,user.getName());
    }

    @Override
    public boolean remove_article(Integer at_id) {
        return this.articleDao.remove_article(at_id);
    }

    @Override
    public boolean edit_article(Article article) {
        return this.articleDao.edit_article(article);
    }

    @Override
    public boolean collect_article(Integer at_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        articleDao.addCollection(at_id);
        //给文章收藏表中插入这条记录
        return this.articleDao.collect_article(at_id,user.getId());
    }

    @Override
    public boolean remove_collect_article(Integer at_id) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        articleDao.decreaseCollection(at_id);
        return this.articleDao.remove_collect_article(at_id,user.getId());
    }

    @Override
    public boolean like_article(Integer at_id) {
        return articleDao.like_article(at_id);
    }
}

