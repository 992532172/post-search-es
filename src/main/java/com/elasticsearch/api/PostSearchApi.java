package com.elasticsearch.api;

import com.elasticsearch.api.rq.QueryPostRq;
import com.elasticsearch.api.rs.QueryPostRs;
import com.elasticsearch.es.index.PostIndex;

/**
 * Created by liang.zhang on 2017/6/15.
 */
public interface PostSearchApi {
    QueryPostRs queryPostInfo(QueryPostRq rq);
}
