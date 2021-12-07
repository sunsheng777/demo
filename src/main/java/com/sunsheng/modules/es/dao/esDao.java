package com.sunsheng.modules.es.dao;

import com.sunsheng.modules.es.entity.esEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface esDao extends ElasticsearchRepository<esEntity, Long> {
}