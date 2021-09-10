package com.zhiliao.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class User implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;//用户ID
    private String name;//用户名
    private String password;
    private String nickname;
    private String gender;
    private String career;
    private String introduction;
    private String address;
    @ApiModelProperty(hidden = true)
    private Date registerdate;
    private String email;
    @ApiModelProperty(hidden = true)
    private String following;//关注
    @ApiModelProperty(hidden = true)
    private String follower;//关注量
    @ApiModelProperty(hidden = true)
    private String collectArticle;
    @ApiModelProperty(hidden = true)
    private String collectAnswer;
    @ApiModelProperty(hidden = true)
    private String answer;
    @ApiModelProperty(hidden = true)
    private Integer likeCount;//喜欢

    }

