package com.sunsheng.modules.es.controller;

import com.sunsheng.common.utils.R;
import com.sunsheng.modules.es.entity.esEntity;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/es")
@RestController
public class EsController {
    @Autowired
    private com.sunsheng.modules.es.dao.esDao esDao;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @ResponseBody
    @RequestMapping("/add")
    public R add() {
        List<esEntity> list = new ArrayList<>();
        esEntity esEntity;
        for (int i = 0; i < 1000; i++) {
            esEntity = new esEntity();
            esEntity.setId(i);
            esEntity.setTitle("ttt" + i);
            esEntity.setImages("image" + i);
            esEntity.setCategory("category" + i);
            esEntity.setPrice(i + 0.0D);
            list.add(esEntity);
        }
        esDao.saveAll(list);
        return R.ok().putData("list", list);
    }

    @ResponseBody
    @RequestMapping("/get")
    public R get(String id) {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.must(QueryBuilders.termQuery("id",id));
        NativeSearchQuery b = new NativeSearchQueryBuilder()
                .withQuery(builder)
//                .withPageable(PageRequest.of(1,10))
                .build();
        IndexCoordinates index = elasticsearchRestTemplate.getIndexCoordinatesFor(esEntity.class);
        List<esEntity> list = elasticsearchRestTemplate.queryForList(b, esEntity.class,index);
        System.out.println(list);
        return R.ok().putData("list", list);
    }
}
