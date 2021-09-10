package com.zhiliao.app.controller;

import com.zhiliao.app.entity.Article;
import com.zhiliao.app.entity.Comment;
import com.zhiliao.app.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags="评论模块")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

//    //发表评论
//    @ApiOperation(value = "对文章发表评论")
//    @GetMapping("/article_comment")
//    public boolean article_comment(Comment comment,Integer at_id){
//        return this.commentService.article_comment(comment,at_id);
//    }
}

