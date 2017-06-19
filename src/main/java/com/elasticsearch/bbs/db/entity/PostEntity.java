package com.elasticsearch.bbs.db.entity;

import java.io.Serializable;
import java.util.Date;

public class PostEntity implements Serializable {
    //
    private Integer postId;

    //
    private Integer boardId;

    //
    private Integer topicId;

    //
    private Integer userId;

    //帖子类型 1：主题帖；2回复帖
    private Byte postType;

    //贴子内容
    private String postText;

    //
    private Date createtime;

    private static final long serialVersionUID = 1L;

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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getPostType() {
        return postType;
    }

    public void setPostType(Byte postType) {
        this.postType = postType;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText == null ? null : postText.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", boardId=").append(boardId);
        sb.append(", topicId=").append(topicId);
        sb.append(", userId=").append(userId);
        sb.append(", postType=").append(postType);
        sb.append(", postText=").append(postText);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}