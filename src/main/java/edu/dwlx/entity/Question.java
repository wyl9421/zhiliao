package edu.dwlx.entity;

import java.util.Date;

public class Question {
    private int id;
    private int uid;                    //提出者的uid
    private String content;             //内容
    private String introduction;        //简介
    private String tag;                 //标签
    private int agreeCount;            //点赞数量
    private String comment;             //对问题的评论表的名字
    private String answer;              //回答表的名字
    private String follower;            //关注者表的名字
    private int viewCount;              //浏览数量
    private int collectCount;           //收藏数量
    private Date createDate;            //创建日期

    public Question(){
        agreeCount = 0;
        comment = "default";
        answer = "default";
        follower = "default";
        viewCount = 0;
        collectCount = 0;
        createDate = new Date(System.currentTimeMillis());
    }

    public Question(int uid, String content){
        this();
        this.uid = uid;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", introduction='" + introduction + '\'' +
                ", tag='" + tag + '\'' +
                ", agreeCount=" + agreeCount +
                ", comment='" + comment + '\'' +
                ", answer='" + answer + '\'' +
                ", follower='" + follower + '\'' +
                ", viewCount=" + viewCount +
                ", collectCount=" + collectCount +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        comment = id + "_question_comment";
        answer = id + "_question_answer";
        follower = id + "_question_follower";
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }
}
