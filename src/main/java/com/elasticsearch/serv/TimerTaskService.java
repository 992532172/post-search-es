package com.elasticsearch.serv;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.stereotype.Service;

import com.elasticsearch.es.index.TimerIndex;
import com.elasticsearch.es.repository.TimerRepository;
import com.elasticsearch.util.DateUtil;

/**
 * Created by liang.zhang on 2017/6/13.
 */
@Service
public class TimerTaskService {
    private Logger logger = LoggerFactory.getLogger(TimerTaskService.class);

    @Value("${task.post.sync.lastaction}")
    private String DEFAULT_LASTACTION;
    @Resource
    private TimerRepository timerRepository;
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    public Date getLastAction(String taskCode) {
        GetQuery query = new GetQuery();
        query.setId(taskCode);
        TimerIndex timerIndex = elasticsearchTemplate.queryForObject(query, TimerIndex.class);
        if (timerIndex == null) {
            return DateUtil.parseAuto2Date(DEFAULT_LASTACTION);
        }
        return timerIndex.getLastaction();
    }

    public void saveLastAction(TimerIndex timerIndex){
        timerRepository.save(timerIndex);
    }

}
