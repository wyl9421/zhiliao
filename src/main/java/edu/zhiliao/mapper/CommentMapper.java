package edu.zhiliao.mapper;

import edu.zhiliao.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommentMapper {
    void insertComment(Map map);

    void deleteComment(@Param("id")int id, @Param("tableName")String tableName);

    List<Comment> searchCommentByTableName(@Param("tableName") String tableName);

    void updateComment(Map map);

    int getCommentCount(@Param("tableName")String tableName);
}
