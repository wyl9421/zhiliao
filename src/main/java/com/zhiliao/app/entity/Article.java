package com.zhiliao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer at_id;//文章ID
    private String at_title;//文章标题
    private Integer tag;//文章标签，用于标识该文章属于什么类别
    private String content;//文章内容
    @ApiModelProperty(hidden = true)
    private String author;//文章的作者
    @ApiModelProperty(hidden = true)
    private Integer agree;//点赞量
    @ApiModelProperty(hidden = true)
    private Integer collection;//点赞量
    @ApiModelProperty(hidden = true)
    private String createtime;//创建时间
    @ApiModelProperty(hidden = true)
    private Integer deleted;//创建时间
}
