package com.elasticsearch.es.index;

import java.io.Serializable;
import java.util.Date;

import org.elasticsearch.index.fielddata.FieldData;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

/**
 * 回复索引，保存贴子回复数据到es
 *
 * Created by liang.zhang on 2017/6/13.
 */
@Document(indexName = "post_search", type = "post")
public class PostIndex implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Field(type = FieldType.Integer)
    private Integer postId;// 回复id

    @Field(type = FieldType.Integer)
    private Integer boardId;// 板块id

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String boardName;// 板块名

    @Field(type = FieldType.Integer)
    private Integer topicId;// 主题名（贴子名）

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String topicTitle;// 贴子标题

    @Field(type = FieldType.Integer)
    private Integer userId;

    @MultiField(mainField = @Field(type = FieldType.String),
            otherFields = {
                    // 拼音分词,方便按拼音查询用户名
                    @InnerField(suffix = "pinyin", indexAnalyzer = "pinyin",type = FieldType.String, index = FieldIndex.analyzed),
                    // ik分词
                    @InnerField(suffix = "china", indexAnalyzer = "ik",type = FieldType.String, index = FieldIndex.analyzed)
            }
    )
    private String userName;

    @Field(type = FieldType.String, index = FieldIndex.analyzed)
    private String postText;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field(type = FieldType.String)
    private Date createTime;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "PostIndex{" +
                "postId=" + postId +
                ", boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", topicId=" + topicId +
                ", topicTitle='" + topicTitle + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", postText='" + postText + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
