package com.elasticsearch.es.index;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by liang.zhang on 2017/6/13.
 */
@Document(indexName = "post_search", type = "timer")
public class TimerIndex implements Serializable {
    private static final long serialVersionUID = -1;

    @Id
    @Field(type = FieldType.String)
    private String taskCode;// 定时任务的标识系统码

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field(type = FieldType.String)
    private Date updatetime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field(type = FieldType.String)
    private Date lastaction;

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getLastaction() {
        return lastaction;
    }

    public void setLastaction(Date lastaction) {
        this.lastaction = lastaction;
    }

    @Override
    public String toString() {
        return "TimerIndex{" +
                "taskCode='" + taskCode + '\'' +
                ", updatetime=" + updatetime +
                ", lastaction=" + lastaction +
                '}';
    }
}
