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
public class Comment implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer co_id;//评论ID
    private String co_content;//评论的内容
    @ApiModelProperty(hidden = true)
    private String co_createtime;//评论的时间
    @ApiModelProperty(hidden = true)
    private Integer deleted;//删除标记
    @ApiModelProperty(hidden = true)
    private Integer agreecount;//点赞量
}

