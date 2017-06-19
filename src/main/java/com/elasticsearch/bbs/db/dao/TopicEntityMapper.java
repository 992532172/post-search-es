package com.elasticsearch.bbs.db.dao;

import com.elasticsearch.bbs.db.entity.TopicEntity;
import com.elasticsearch.bbs.db.entity.TopicEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicEntityMapper {
    int countByExample(TopicEntityExample example);

    int deleteByExample(TopicEntityExample example);

    int deleteByPrimaryKey(Integer topicId);

    int insert(TopicEntity record);

    int insertSelective(TopicEntity record);

    List<TopicEntity> selectByExample(TopicEntityExample example);

    TopicEntity selectByPrimaryKey(Integer topicId);

    int updateByExampleSelective(@Param("record") TopicEntity record, @Param("example") TopicEntityExample example);

    int updateByExample(@Param("record") TopicEntity record, @Param("example") TopicEntityExample example);

    int updateByPrimaryKeySelective(TopicEntity record);

    int updateByPrimaryKey(TopicEntity record);
}