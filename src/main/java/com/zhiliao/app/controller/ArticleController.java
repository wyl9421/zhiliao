package com.zhiliao.app.controller;

import com.zhiliao.app.entity.Article;
import com.zhiliao.app.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "文章模块API")
@RestController
@RequestMapping("/article")

public class ArticleController {
    @Resource
    private ArticleService articleService;

    //添加文章
    @ApiOperation(value = "发表文章")
    @GetMapping("/add_article")
    public boolean add_article(Article article){
        return this.articleService.add_article(article);
    }

    //删除文章
    @ApiOperation(value = "删除文章")
    @GetMapping("/remove_article")
    public boolean remove_article(Integer at_id){
        return this.articleService.remove_article(at_id);
    }

    //修改文章
    @ApiOperation(value = "修改文章")
    @GetMapping("/edit_article")
    public boolean edit_article(Article article){
        return this.articleService.edit_article(article);
    }

    //对喜欢的文章进行收藏
    @ApiOperation(value = "收藏文章")
    @GetMapping("/collect_article")
    public boolean collect_article(Integer at_id){
        return articleService.collect_article(at_id);
    }

    //取消文件收藏
    @ApiOperation(value = "取消收藏")
    @GetMapping("/remove_collect_article")
    public boolean remove_collect_article(Integer at_id){
        return articleService.remove_collect_article(at_id);
    }

    //给文章点赞
    @ApiOperation(value = "文章点赞")
    @GetMapping("/like_article")
    public boolean like_article(Integer at_id){
        return articleService.like_article(at_id);
    }

}
