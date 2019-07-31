package com.lgy.common.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Elasticsearch 用于大数据分析
 */
@NoRepositoryBean
public interface AbstractRepository<T> extends ElasticsearchRepository<T, Long> {

}
