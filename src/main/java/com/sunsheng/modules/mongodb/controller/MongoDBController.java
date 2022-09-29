//package com.sunsheng.modules.mongodb.controller;
//
//import com.mongodb.client.result.UpdateResult;
//import com.sunsheng.common.utils.R;
//import com.sunsheng.modules.mongodb.entity.MongoDBEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@RestController
//@RequestMapping("/mongo")
//public class MongoDBController {
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @RequestMapping(value = "/addAll")
//    public R addAll() {
//        Collection<MongoDBEntity> list = new ArrayList<>();
//        MongoDBEntity entity;
//        for (int i = 0; i < 100; i++) {
//            entity = new MongoDBEntity();
//            entity.setId(i);
//            entity.setName("name" + i);
//            list.add(entity);
//        }
//        Collection<MongoDBEntity> s = mongoTemplate.insert(list, MongoDBEntity.class);
//        return R.ok().putData("list", s);
//    }
//
//    @RequestMapping(value = "/update")
//    public R update(Integer id) {
//        MongoDBEntity entity1 = null;
//        if (null != id) {
//            MongoDBEntity entity = mongoTemplate.findById(id, MongoDBEntity.class);
//            if (null != entity) {
//                entity.setName("修改后的名字是xxx");
//                entity1 = mongoTemplate.save(entity);
//            }
//        }
//        return R.ok().put("time", entity1);
//    }
//
//    @RequestMapping(value = "/updateTest")
//    public R updateTest(Integer id) {
//        Query query = Query.query(
//                Criteria.where("id").is(15)
//        );
//        Update update = Update.update("Name", "修改后的名字");
//        UpdateResult updateFirst = mongoTemplate.updateFirst(query, update, MongoDBEntity.class);
//        return R.ok().put("time", updateFirst);
//    }
//
//    @RequestMapping(value = "/list")
//    public R list() {
//        return R.ok().putData("time", mongoTemplate.findAll(MongoDBEntity.class));
//    }
//
//    @RequestMapping("/findByName")
//    public R findByName() {
//        Query query = new Query(Criteria.where("name").is("Name88"));
//        List<MongoDBEntity> list = mongoTemplate.find(query, MongoDBEntity.class);
//        return R.ok().putData("list", list);
//    }
//
////    @PostMapping("/uploadFile")
////    public R uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
////        Object o = gridFsTemplate.store(
////                file.getInputStream(),
////                file.getOriginalFilename(),
////                file.getContentType()
////        );
////        return R.ok().putData("id", o);
////    }
//}
