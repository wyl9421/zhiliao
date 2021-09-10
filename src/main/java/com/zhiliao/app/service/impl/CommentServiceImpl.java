package com.zhiliao.app.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiliao.app.entity.Comment;
import com.zhiliao.app.dao.CommentDao;
import com.zhiliao.app.entity.User;
import com.zhiliao.app.service.CommentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {
    @Resource
    private CommentDao commentDao;

//    @Override
//    public boolean article_comment(Comment comment,Integer at_id) {
//        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
//        commentDao.article_comment(comment.getCo_content());
//        Integer coid = comment.getCo_id();
//        Integer uid = user.getId();
//        return commentDao.add_article_comment(coid,at_id,uid);
//    }
}
