package com.elasticsearch.es.repository;

import com.elasticsearch.es.index.PostIndex;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by liang.zhang on 2017/6/13.
 */
public interface PostRepository extends PagingAndSortingRepository<PostIndex, Integer> {
}
