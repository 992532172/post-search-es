package com.elasticsearch.apiservice;

import com.elasticsearch.api.PostSearchApi;
import com.elasticsearch.api.rq.QueryPostRq;
import com.elasticsearch.api.rs.QueryPostRs;
import com.elasticsearch.es.index.PostIndex;
import com.elasticsearch.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostSearchService implements PostSearchApi {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public QueryPostRs queryPostInfo(QueryPostRq rq) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 字段搜索
        if (StringUtils.isNoneBlank(rq.getPostText())) {
            boolQueryBuilder.must(QueryBuilders.prefixQuery("postText", rq.getPostText()));
        }

        if (StringUtils.isNotBlank(rq.getPostTitle())) {
            boolQueryBuilder.must(QueryBuilders.prefixQuery("postTitle", rq.getPostTitle()));
        }

        if (StringUtils.isNotBlank(rq.getBoardName())) {
            boolQueryBuilder.must(QueryBuilders.prefixQuery("boardName", rq.getBoardName()));
        }

        if (StringUtils.isNotBlank(rq.getUserName())) {
            String rqReg = rq.getUserName();
//            rqReg = rqReg + "*";
            if(StringUtil.matchChina(rq.getUserName())){
                boolQueryBuilder.must(QueryBuilders.prefixQuery("userName.china", rqReg));
            } else {
                boolQueryBuilder.must(QueryBuilders.prefixQuery("userName.pinyin", rqReg));
            }
        }

        // 日期范围
        RangeQueryBuilder dateRangeQuery = QueryBuilders.rangeQuery("createDate");
        if (StringUtils.isNotBlank(rq.getStartDate())) {
            dateRangeQuery.gte(rq.getStartDate());
        }
        if (StringUtils.isNotBlank(rq.getEndDate())) {
            dateRangeQuery.lte(rq.getEndDate());
        }

        // 根据输入进行多词条模糊搜索
        if (StringUtils.isNotBlank(rq.getRqStr())) {
            String rqReg = rq.getRqStr();
            BoolQueryBuilder searchBuilder = QueryBuilders.boolQuery();
            searchBuilder.should(QueryBuilders.prefixQuery("postTitle", rqReg));
            searchBuilder.should(QueryBuilders.prefixQuery("postText", rqReg));
            searchBuilder.should(QueryBuilders.prefixQuery("userName.china", rqReg));
            searchBuilder.should(QueryBuilders.prefixQuery("userName.pinyin", rqReg));
            searchBuilder.should(QueryBuilders.prefixQuery("topicTitle", rqReg));
            searchBuilder.should(QueryBuilders.prefixQuery("topciDesc", rqReg));
            boolQueryBuilder.must(searchBuilder);
        }

        // 排序
        List<SortBuilder> sorts = new ArrayList<>();
        FieldSortBuilder sort = SortBuilders.fieldSort("createTime");
        sort.order(SortOrder.DESC);
        sorts.add(sort);

        SearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder, null, sorts);
        List<PostIndex> postIndexs = elasticsearchTemplate.queryForList(searchQuery, PostIndex.class);
        QueryPostRs rs = new QueryPostRs();
        rs.setPostIndex(postIndexs);
        return rs;
    }
}
