package edu.dwlx.controller.answer;

import edu.dwlx.entity.Answer;
import edu.dwlx.entity.Question;
import edu.dwlx.services.AnswerService;
import edu.dwlx.services.QuestionService;
import edu.dwlx.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/zhifou/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    //获得回答
    @RequestMapping("/get/{table}")
    @ResponseBody
    public List<Answer> getQuestionAnswer(@PathVariable("table") String table) {
        return answerService.searchAnswerByTableName(table);
    }
    //添加回答
    @RequestMapping("/put")
    @ResponseBody
    public boolean getQuestionAnswer(int uid, int qid, String content) {
        Answer answer = new Answer();
        answer.setUid(uid);
        answer.setQuestionId(qid);
        answer.setContent(content);
        answerService.insertAnswer(answer);
        Answer answer1 = answerService.searchAnswerByContentAndUid(answer);
        Question question = questionService.searchQuestionById(qid);
        question.setViewCount(question.getViewCount() + 1);

        userService.insertUserAnswer(answer1);
        return true;
    }
}
