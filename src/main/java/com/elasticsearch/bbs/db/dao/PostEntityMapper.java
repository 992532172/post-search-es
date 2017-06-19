package com.elasticsearch.bbs.db.dao;

import com.elasticsearch.bbs.db.entity.PostEntity;
import com.elasticsearch.bbs.db.entity.PostEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostEntityMapper {
    int countByExample(PostEntityExample example);

    int deleteByExample(PostEntityExample example);

    int deleteByPrimaryKey(Integer postId);

    int insert(PostEntity record);

    int insertSelective(PostEntity record);

    List<PostEntity> selectByExample(PostEntityExample example);

    PostEntity selectByPrimaryKey(Integer postId);

    int updateByExampleSelective(@Param("record") PostEntity record, @Param("example") PostEntityExample example);

    int updateByExample(@Param("record") PostEntity record, @Param("example") PostEntityExample example);

    int updateByPrimaryKeySelective(PostEntity record);

    int updateByPrimaryKey(PostEntity record);
}