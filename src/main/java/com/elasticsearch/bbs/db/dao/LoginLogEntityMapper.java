package com.elasticsearch.bbs.db.dao;

import com.elasticsearch.bbs.db.entity.LoginLogEntity;
import com.elasticsearch.bbs.db.entity.LoginLogEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginLogEntityMapper {
    int countByExample(LoginLogEntityExample example);

    int deleteByExample(LoginLogEntityExample example);

    int deleteByPrimaryKey(Integer loginLogId);

    int insert(LoginLogEntity record);

    int insertSelective(LoginLogEntity record);

    List<LoginLogEntity> selectByExample(LoginLogEntityExample example);

    LoginLogEntity selectByPrimaryKey(Integer loginLogId);

    int updateByExampleSelective(@Param("record") LoginLogEntity record, @Param("example") LoginLogEntityExample example);

    int updateByExample(@Param("record") LoginLogEntity record, @Param("example") LoginLogEntityExample example);

    int updateByPrimaryKeySelective(LoginLogEntity record);

    int updateByPrimaryKey(LoginLogEntity record);
}