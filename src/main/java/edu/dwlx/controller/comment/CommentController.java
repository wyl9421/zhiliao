package edu.dwlx.controller.comment;

import edu.dwlx.entity.Answer;
import edu.dwlx.entity.Article;
import edu.dwlx.entity.Comment;
import edu.dwlx.entity.Question;
import edu.dwlx.mapper.CommentMapper;
import edu.dwlx.services.AnswerService;
import edu.dwlx.services.ArticleService;
import edu.dwlx.services.CommentService;
import edu.dwlx.services.QuestionService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/zhifou/comment")
public class CommentController {
/*1. 评论表内容
请求方式：post
请求地址：zhifou/comment
请求参数：{ "comment": 评论表名 }
请求数据：评论信息
2. 获取总评论的条数
请求方式：get
请求地址：zhifou/comment/评论表名/number
请求数据：评论表内的评论条数。
*/
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    QuestionService questionService;
    @Autowired
    CommentService commentService;
    @Autowired
    ArticleService articleService;
    @Autowired
    AnswerService answerService;
    //评论表内容
    @RequestMapping
    @ResponseBody
    public List<Comment> getCommentList(String comment) {
        List<Comment> commentList = commentMapper.searchCommentByTableName(comment);
//        for(Comment c:commentList)
//            System.out.println(c.toString());
        return commentList;
    }
    //获取总评论的条数
    @RequestMapping("/{table}/number")
    @ResponseBody
    public int getCommentNumber(@PathVariable("table") String comment) {
        List<Comment> list = commentService.searchCommentByTableName(comment);
        return commentService.getCollectCount(comment);
    }
    //添加评论, 问题和文章
    @RequestMapping("/{kind}/{id}/add")
    @ResponseBody
    public boolean commitComment(@PathVariable("kind") String kind,
                                 @PathVariable("id") int id, int uid,
                                 String content) {
        Comment comment1 = new Comment();
        comment1.setContent(content);
        comment1.setUid(uid);
        comment1.setAgree(0);
        Date date = new Date(System.currentTimeMillis());
        comment1.setToWho(-1);
        comment1.setCreateDate(date);

        if(kind.equals("question"))
            commentService.insertComment(comment1, id + "_question_comment");
        else if(kind.equals("article"))
            commentService.insertComment(comment1, id + "_article_comment");
        else
            return false;
        return true;
    }
    //添加评论, 回答
    @RequestMapping("/answer/{qid}/{aid}/add")
    @ResponseBody
    public boolean commitAnswerComment(@PathVariable("qid") int qid,
                                       @PathVariable("aid") int aid,
                                       int uid, String content) {
        Comment comment1 = new Comment();
        comment1.setContent(content);
        comment1.setUid(uid);
        comment1.setAgree(0);
        Date date = new Date(System.currentTimeMillis());
        comment1.setToWho(-1);
        comment1.setCreateDate(date);
        commentService.insertComment(comment1, qid + "_" + aid + "_answer_comment");
        return true;
    }
}
