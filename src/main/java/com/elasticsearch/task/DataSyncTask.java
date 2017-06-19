package com.elasticsearch.task;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.elasticsearch.common.TimerTaskCodeEnum;
import com.elasticsearch.es.index.TimerIndex;
import com.elasticsearch.serv.PostIndexService;
import com.elasticsearch.serv.TimerTaskService;

@Component
public class DataSyncTask {
    private Logger logger = LoggerFactory.getLogger(DataSyncTask.class);

    @Resource
    private TimerTaskService timerTaskService;
    @Resource
    private PostIndexService postIndexService;

    @Scheduled(cron = "${task.post.sync}")
    public void syncPostDetail(){
        Date lastAction = timerTaskService.getLastAction(TimerTaskCodeEnum.POST_TIMER_TASK.name());
        logger.info("开始同步论坛回复数据,lastAction:{}", lastAction);
        try {
            // 按起止时间同步数据
            Date now = new Date();
            postIndexService.syncPostInfo(lastAction, now);
            
            // 同步数据结束,保存此次同步时间
            TimerIndex timerIndex = new TimerIndex();
            timerIndex.setTaskCode(TimerTaskCodeEnum.POST_TIMER_TASK.name());
            timerIndex.setLastaction(now);
            timerIndex.setUpdatetime(now);
            timerTaskService.saveLastAction(timerIndex);
        } catch (Exception e){
            logger.error("同步数据异常", e);
        }
        logger.info("同步数据结束");
    }
}
