package com.zhiliao.app.controller;

import com.zhiliao.app.entity.Answer;
import com.zhiliao.app.entity.Article;
import com.zhiliao.app.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags="回答模块Api")
@RestController
@RequestMapping("answer")
public class AnswerController{
    @Resource
    private AnswerService answerService;


    //添加文章
    @ApiOperation(value = "回答问题")
    @GetMapping("/add_answer")
    public boolean add_answer(Answer answer){
        return this.answerService.add_answer(answer);
    }

    //删除文章
    @ApiOperation(value = "删除回答")
    @GetMapping("/remove_answer")
    public boolean remove_answer(Integer an_id){
        return this.answerService.remove_answer(an_id);
    }



}

