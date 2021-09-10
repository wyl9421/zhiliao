package com.zhiliao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer qs_id;//问题ID
    private String content;//问题内容
    private String tag;//问题标签
    private String author;//问题提出者
    @ApiModelProperty(hidden = true)
    private Integer agreecount;//问题点赞量
    @ApiModelProperty(hidden = true)
    private Integer viewcount;//问题访问量
    @ApiModelProperty(hidden = true)
    private Integer collectcount;//问题收藏量
    @ApiModelProperty(hidden = true)
    private String createtime;//问题提出时间
    @ApiModelProperty(hidden = true)
    private Integer deleted;//问题提出时间
}

