package com.zhiliao.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer an_id;//回答ID
    private Integer qs_id;//回答的问题ID
    @ApiModelProperty(hidden = true)
    private String an_name;//谁回答的
    private String content;//回答的内容
    @ApiModelProperty(hidden = true)
    private Integer agreecount;//喜欢
    @ApiModelProperty(hidden = true)
    private Integer disagreecount;//不喜欢
    @ApiModelProperty(hidden = true)
    private String createtime;//回答时间
    }

