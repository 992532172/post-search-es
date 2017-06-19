package com.elasticsearch.serv;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.elasticsearch.bbs.db.dao.BoardEntityMapper;
import com.elasticsearch.bbs.db.dao.PostEntityMapper;
import com.elasticsearch.bbs.db.dao.TopicEntityMapper;
import com.elasticsearch.bbs.db.dao.UserEntityMapper;
import com.elasticsearch.bbs.db.entity.BoardEntity;
import com.elasticsearch.bbs.db.entity.PostEntity;
import com.elasticsearch.bbs.db.entity.PostEntityExample;
import com.elasticsearch.bbs.db.entity.TopicEntity;
import com.elasticsearch.bbs.db.entity.UserEntity;

/**
 * Created by liang.zhang on 2017/6/13.
 */
@Service
public class PostDbService {

    private Logger logger = LoggerFactory.getLogger(PostDbService.class);

    @Resource
    private PostEntityMapper postEntityMapper;
    @Resource
    private UserEntityMapper userEntityMapper;
    @Resource
    private BoardEntityMapper boardEntityMapper;
    @Resource
    private TopicEntityMapper topicEntityMapper;

    private static int DEFAULT_POST_PAGE_SIZE = 100;

    public List<PostEntity> pagePostsByCreateTime(Date from, Date to, Integer start) {
        if (from == null) {
            return null;
        }
        if (to == null){
            to = new Date();
        }
        PostEntityExample example = new PostEntityExample();
        example.createCriteria().andCreatetimeBetween(from, to);
        example.setLimitSize(DEFAULT_POST_PAGE_SIZE);
        example.setLimitStart(start * DEFAULT_POST_PAGE_SIZE);
        List<PostEntity> posts = postEntityMapper.selectByExample(example);
        return posts;
    }

    public UserEntity findUserById(Integer userId) {
        if (userId == null || userId == 0) {
            return null;
        }
        return userEntityMapper.selectByPrimaryKey(userId);
    }

    public TopicEntity findTopicById(Integer topicId) {
        if (topicId == null || topicId == 0) {
            return null;
        }
        return topicEntityMapper.selectByPrimaryKey(topicId);
    }

    public BoardEntity findBoardById(Integer boardId) {
        if (boardId == null || boardId == 0) {
            return null;
        }
        return boardEntityMapper.selectByPrimaryKey(boardId);
    }
}
