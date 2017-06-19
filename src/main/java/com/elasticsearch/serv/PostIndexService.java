package com.elasticsearch.serv;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.elasticsearch.bbs.db.entity.BoardEntity;
import com.elasticsearch.bbs.db.entity.PostEntity;
import com.elasticsearch.bbs.db.entity.TopicEntity;
import com.elasticsearch.bbs.db.entity.UserEntity;
import com.elasticsearch.es.index.PostIndex;
import com.elasticsearch.es.repository.PostRepository;
import com.elasticsearch.util.DateUtil;

/**
 * Created by liang.zhang on 2017/6/13.
 */
@Service
public class PostIndexService {
    private Logger logger = LoggerFactory.getLogger(PostIndexService.class);

    @Resource
    private PostDbService postDbService;
    @Resource
    private PostRepository postRepository;

    public void syncPostInfo(Date lastAction, Date now) {
        // 分页查询数据库
        int times = 0;
        while (true) {
            List<PostEntity> postEntityList = postDbService.pagePostsByCreateTime(lastAction, now, times);
            if (CollectionUtils.isEmpty(postEntityList)) {
                break;// 查询不到数据则结束循环
            }
            postEntityList.parallelStream().forEach(post -> {
                PostIndex index = trans2Index(post);
                postRepository.save(index);
            });
            times++;
            logger.info("同步成功,lastAction:{},size:{}条", DateUtil.format(lastAction, DateUtil.DATE_TIME_FORMAT), postEntityList.size());
        }
    }

    private PostIndex trans2Index(PostEntity entity) {
        PostIndex index = new PostIndex();
        index.setPostId(entity.getPostId());
        BoardEntity boardEntity = postDbService.findBoardById(entity.getBoardId());
        index.setBoardId(entity.getBoardId());
        index.setBoardName(boardEntity.getBoardName());
        TopicEntity topicEntity = postDbService.findTopicById(entity.getTopicId());
        index.setTopicId(topicEntity.getTopicId());
        index.setTopicTitle(topicEntity.getTopicTitle());
        UserEntity userEntity = postDbService.findUserById(entity.getUserId());
        index.setUserId(userEntity.getUserId());
        index.setUserName(userEntity.getUserName());
        index.setCreateTime(entity.getCreatetime());
        index.setPostText(entity.getPostText());
        return index;
    }
}
