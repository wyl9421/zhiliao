package com.zhiliao.app.controller;

import com.zhiliao.app.entity.Question;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags="问题模块Api")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    //添加问题
    @ApiOperation(value = "发表问题")
    @GetMapping("/add_question")
    public boolean add_question(Question question) {
        return questionService.add_question(question);
    }

    //删除问题
    @ApiOperation(value = "删除问题")
    @GetMapping("/remove_question")
    public boolean remove_question(Integer qs_id) {
        return questionService.remove_question(qs_id);
    }

    //问题收藏
    @ApiOperation(value = "问题收藏")
    @GetMapping("/collect_question")
    public boolean collect_question(Integer qs_id) {
        return questionService.collect_question(qs_id);
    }

    //问题收藏
    @ApiOperation(value = "取消问题收藏")
    @GetMapping("/remove_collect_question")
    public boolean remove_collect_question(Integer qs_id) {
        return questionService.remove_collect_question(qs_id);
    }

    //给问题点赞
    @ApiOperation(value = "给问题点赞")
    @GetMapping("/like_question")
    public boolean like_question(Integer qs_id) {
        return questionService.like_question(qs_id);
    }
}

