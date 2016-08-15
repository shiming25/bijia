package com.shim.util;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.sou.common.util.SpringContextHelper;
import com.sou.common.util.StringUtil;

public class MongoUtil {
    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(MongoUtil.class);

    MongoTemplate mongoTemplate = (MongoTemplate) SpringContextHelper.getBean("mongoTemplate");

    public JSONObject add(String businessContent, String colletionName) {
        try {
            JSONObject jsonObj = JSON.parseObject(businessContent);

            // Map map = (Map)JSONObject.toBean(jsonObj, Map.class);
            // BasicDBObject insertParam = (BasicDBObject)JSONObject.toBean(jsonObj, BasicDBObject.class);
            BasicDBObject insertParam = (BasicDBObject) JSON.parseObject(businessContent, BasicDBObject.class);
            mongoTemplate.insert(insertParam, colletionName);
            jsonObj.put("_id", insertParam.getObjectId("_id").toString());
            return jsonObj;
            // return jsonObj;
        } catch (Exception e) {
            LOG.debug("add  ", e.getStackTrace());
            return null;
        }
    }

    public JSONObject add(JSONObject jsonObj, String colletionName) {
        try {

            // Map map = (Map)JSONObject.toBean(jsonObj, Map.class);
            // BasicDBObject insertParam = (BasicDBObject)JSONObject.toBean(jsonObj, BasicDBObject.class);
            BasicDBObject insertParam = (BasicDBObject) JSON.parseObject(jsonObj.toString(), BasicDBObject.class);
            mongoTemplate.insert(insertParam, colletionName);
            jsonObj.put("_id", insertParam.getObjectId("_id").toString());
            return jsonObj;
            // return jsonObj;
        } catch (Exception e) {
            LOG.debug("add  ", e.getStackTrace());
            return null;
        }
    }

    public List<DBObject> queryTaskDetail(String businessContent, String collectionName) {
        JSONObject jsonObject = JSON.parseObject(businessContent);
        String id = jsonObject.getString("id");
        String openId = jsonObject.getString("openId");
        BasicDBList a = new BasicDBList();
        DBObject queryObject = new BasicDBObject("openId", openId);
        a.add(queryObject);

        if (!StringUtil.isBlank(id)) {
            DBObject queryObject2 = new BasicDBObject("_id", new ObjectId(id));
            a.add(queryObject2);
            // query.addCriteria(Criteria.where("_id").is(id));
        }
        DBObject queryObjectAll = new BasicDBObject("$and", a);
        Query query = new BasicQuery(queryObjectAll);
        query.with(new Sort(new Order(Direction.DESC, "openId")));
        List<DBObject> list = mongoTemplate.find(query, DBObject.class, collectionName);
        if (null != list && !list.isEmpty()) {
            for (DBObject data : list) {
                ObjectId objectId = (ObjectId) data.get("_id");
                // data.put("taskId", id.toString());
            }
        }

        return list;
    }

    public List<DBObject> queryTaskDetail(JSONObject jsonObject, String collectionName) {
        String id = jsonObject.getString("id");
        String openId = jsonObject.getString("openId");
        BasicDBList a = new BasicDBList();
        DBObject queryObject = new BasicDBObject("openId", openId);
        a.add(queryObject);

        if (!StringUtil.isBlank(id)) {
            DBObject queryObject2 = new BasicDBObject("_id", new ObjectId(id));
            a.add(queryObject2);
            // query.addCriteria(Criteria.where("_id").is(id));
        }
        DBObject queryObjectAll = new BasicDBObject("$and", a);
        Query query = new BasicQuery(queryObjectAll);
        query.with(new Sort(new Order(Direction.DESC, "createTime")));
        List<DBObject> list = mongoTemplate.find(query, DBObject.class, collectionName);
        if (null != list && !list.isEmpty()) {
            for (DBObject data : list) {
                ObjectId objectId = (ObjectId) data.get("_id");
                // data.put("taskId", id.toString());
            }
        }

        return list;
    }
    
    public DBObject queryLastDetail(JSONObject jsonObject, String collectionName) {
        String id = jsonObject.getString("id");
        String openId = jsonObject.getString("openId");
        BasicDBList a = new BasicDBList();
        DBObject queryObject = new BasicDBObject("openId", openId);
        a.add(queryObject);

        if (!StringUtil.isBlank(id)) {
            DBObject queryObject2 = new BasicDBObject("_id", new ObjectId(id));
            a.add(queryObject2);
            // query.addCriteria(Criteria.where("_id").is(id));
        }
        DBObject queryObjectAll = new BasicDBObject("$and", a);
        Query query = new BasicQuery(queryObjectAll);
        query.with(new Sort(new Order(Direction.DESC, "createTime")));
       DBObject dbObj = mongoTemplate.findOne(query, DBObject.class, collectionName);

        return dbObj;
    }    

    public static void main(String[] args) {
        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("config/spring/spring-tour-root.xml");
        MongoUtil testMon = new MongoUtil();
        JSONObject json = new JSONObject();
        json.put("openId", "test");
        json.put("ltn", 7113);
        json.put("rtn", 7214);
        json.put("createTime", System.currentTimeMillis());
        testMon.add(json, "mapTest");
        
        DBObject ret = testMon.queryLastDetail(json, "mapTest");
        System.out.println(ret.toString());
        
    }
}
