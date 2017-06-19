package com.elasticsearch.es.repository;

import com.elasticsearch.es.index.TimerIndex;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by liang.zhang on 2017/6/13.
 */
public interface TimerRepository extends PagingAndSortingRepository<TimerIndex, String> {
}
