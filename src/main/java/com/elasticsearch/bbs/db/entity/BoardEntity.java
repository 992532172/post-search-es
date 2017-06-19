package com.elasticsearch.bbs.db.entity;

import java.io.Serializable;

public class BoardEntity implements Serializable {
    //
    private Integer boardId;

    //板块名称
    private String boardName;

    //板块描述
    private String boardDesc;

    //板块主题数
    private Integer topicNum;

    //创建人id
    private Integer creator;

    private static final long serialVersionUID = 1L;

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
        this.boardName = boardName == null ? null : boardName.trim();
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc == null ? null : boardDesc.trim();
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", boardId=").append(boardId);
        sb.append(", boardName=").append(boardName);
        sb.append(", boardDesc=").append(boardDesc);
        sb.append(", topicNum=").append(topicNum);
        sb.append(", creator=").append(creator);
        sb.append("]");
        return sb.toString();
    }
}