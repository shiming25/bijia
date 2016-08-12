/**************************************************************************************** 

 ****************************************************************************************/
package com.weixin.gra.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * <Description> <br>
 * 
 * @author zhangai<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年8月3日 <br>
 */

public class TestMongo {
    /**
     * THREADNUM
     */
    public static final int THREADNUM = 3;

    /**
     * Description: <br>
     * 
     * @author zhangai<br>
     * @taskId <br>
     * @param args <br>
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        TestMongo a1 = new TestMongo();
        a1.testBegin();
       
        ConfigurableApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("config/spring/spring-tour-root.xml");

        

        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        
        JSONObject jsobj = new JSONObject();

        jsobj.put("id", "111");
        jsobj.put("name", "testName");
        
        mongoTemplate.save(jsobj, "test");
        

        if (1 == 1) {
            return;
        }
        
        
        // DBObject queryObject2 = new BasicDBObject("taskType","2");
        DBObject queryObject = new BasicDBObject("taskType", new BasicDBObject("$lt", "4"));
        DBObject queryObject2 = new BasicDBObject("taskType", new BasicDBObject("$gt", "0"));
        // queryObject.put("_id", new BasicDBObject("$gt","5719e583498e2b7209d1cb01"));
        // queryObject.put("taskType", new BasicDBObject("$gt","0"));

        BasicDBList a = new BasicDBList();
        a.add(queryObject);
        a.add(queryObject2);

        DBObject queryObjectAll = new BasicDBObject("$and", a);

        Query query = new BasicQuery(queryObjectAll);
        query.skip(0).limit(12);
        query.with(new Sort(Direction.ASC, "channel"));
        List<JSONObject> datas = mongoTemplate.find(query, JSONObject.class, "task");
        System.out.print("ssssss");

        // logHandle.getConsumerIns().initConsumerConn();
        //
        // // logHandle.test("dq", 1, true);
        //
        // logHandle.run(THREADNUM, "elog");

    }

    /**
     * Description: test<br>
     * 
     * @author lenovo<br>
     * @taskId <br>
     * <br>
     */
    public void test() {
        int i = 0;
        i = i + 1;
    }

    public void testBegin() {
        JSONObject jsobj = new JSONObject();
        JSONArray jsobjArr = new JSONArray();

        jsobj.put("id", "111");
        jsobj.put("name", "testName");
        jsobj.put("parId", "1");
        jsobjArr.add(jsobj);

        jsobj = new JSONObject();
        jsobj.put("id", "222");
        jsobj.put("name", "testName22");
        jsobj.put("parId", "111");
        jsobjArr.add(jsobj);

        jsobj = new JSONObject();
        jsobj.put("id", "112");
        jsobj.put("name", "testName1122");
        jsobj.put("parId", "1");
        jsobjArr.add(jsobj);
        JSONObject jsobjPub = new JSONObject();
        testD(jsobjArr, "1", jsobjPub);

        System.out.println(jsobjPub.toString());

    }

    // JSONObject jsobjPub = new JSONObject();
    public void testD(JSONArray list, String parId, JSONObject jsobjPub) {
        // List list = new ArrayList();
        JSONArray jsA = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject obj = (JSONObject) list.get(i);
           
            if (obj != null && obj.getString("parId").equals(parId)) {
                JSONObject obj2 = new JSONObject() ;
                obj2.put("id", obj.get("id"));
                obj2.put("name", obj.get("name"));
                obj2.put("parId", obj.get("parId"));
               
                 testD(list,obj2.getString("id"),obj2);
                 jsA.add(obj2);
                 System.out.println(obj2.toString());
            }

        }
        if(null != jsA && jsA.size() >0) {
            jsobjPub.put("children", jsA);
        }
        
    }

}
