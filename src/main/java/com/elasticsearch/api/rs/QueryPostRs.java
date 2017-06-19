package com.elasticsearch.api.rs;

import com.elasticsearch.es.index.PostIndex;

import java.util.List;

/**
 * Created by liang.zhang on 2017/6/15.
 */
public class QueryPostRs {
    private List<PostIndex> postIndex;

    public List<PostIndex> getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(List<PostIndex> postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public String toString() {
        return "QueryPostRs{" +
                "postIndex=" + postIndex +
                '}';
    }
}
