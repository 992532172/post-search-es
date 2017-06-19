package com.elasticsearch.web;

import com.elasticsearch.api.rq.QueryPostRq;
import com.elasticsearch.api.rs.QueryPostRs;
import com.elasticsearch.apiservice.PostSearchService;
import com.elasticsearch.es.index.PostIndex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by liang.zhang on 2017/6/15.
 */
@Controller
public class PostSearchController {
    @Resource
    private PostSearchService postSearchService;

//    @RequestMapping(value = "/queryPostInfo", method = RequestMethod.GET)
//    @ResponseBody
    public String queryPostIndex() {
        return "OK";
    }

    @RequestMapping(value = "/postSearch/queryPostInfo", method = RequestMethod.POST)
    @ResponseBody
    public QueryPostRs queryPost(@RequestBody QueryPostRq rq) {
        return postSearchService.queryPostInfo(rq);
    }
}
