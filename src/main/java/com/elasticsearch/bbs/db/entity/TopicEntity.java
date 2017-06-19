package com.elasticsearch.bbs.db.entity;

import java.io.Serializable;
import java.util.Date;

public class TopicEntity implements Serializable {
    //
    private Integer topicId;

    //
    private Integer boardId;

    //
    private String topicTitle;

    //
    private Integer userId;

    //创建时间
    private Date createTime;

    //最后回复时间
    private Date lastPost;

    //浏览次数
    private Integer topicView;

    //回复次数
    private Integer topicReplies;

    //是否精品 0:非精品；1:精品
    private Byte digest;

    private static final long serialVersionUID = 1L;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle == null ? null : topicTitle.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public Integer getTopicView() {
        return topicView;
    }

    public void setTopicView(Integer topicView) {
        this.topicView = topicView;
    }

    public Integer getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(Integer topicReplies) {
        this.topicReplies = topicReplies;
    }

    public Byte getDigest() {
        return digest;
    }

    public void setDigest(Byte digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", topicId=").append(topicId);
        sb.append(", boardId=").append(boardId);
        sb.append(", topicTitle=").append(topicTitle);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastPost=").append(lastPost);
        sb.append(", topicView=").append(topicView);
        sb.append(", topicReplies=").append(topicReplies);
        sb.append(", digest=").append(digest);
        sb.append("]");
        return sb.toString();
    }
}