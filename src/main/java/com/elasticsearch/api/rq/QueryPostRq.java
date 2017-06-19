package com.elasticsearch.api.rq;

/**
 * Created by liang.zhang on 2017/6/15.
 */
public class QueryPostRq {
    private String rqStr;

    private String postText;

    private String postTitle;

    private String startDate;

    private String endDate;

    private String userName;

    private String boardName;

    public String getRqStr() {
        return rqStr;
    }

    public void setRqStr(String rqStr) {
        this.rqStr = rqStr;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "QueryPostRq{" +
                "rqStr='" + rqStr + '\'' +
                ", postText='" + postText + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", userName='" + userName + '\'' +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
