package com.sou.common.util.jackson;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * ObjectMapper单例，主要是配置ObjectMapper，解决jackson readValue方法返回结果为模板类的问题。注：获取单例后不要对instance做任何修改。<br>
 * 
 * @author 
 */
public class ObjectMapperSingleton {

    private static Logger logger = Logger.getLogger(ObjectMapperSingleton.class);

    private static ObjectMapper instance;

    public static synchronized ObjectMapper getInstance() {

        if (instance == null) {

            instance = new ObjectMapper();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 忽略unknown属性
            instance.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // 指定时间格式
            instance.setDateFormat(sdf);
        }

        return instance;
    }

    /**
     * 将json字符串转换为ResponseFormat<T>，T为实体bean。<br>
     * 
     * @param content
     * @param valueType
     * @param beanType
     * @param nodeName
     * @return
     */
    public static <T, E> T readValue(String content, Class<T> valueType, Class<E> beanType, String nodeName) {

        T result = null;

        ObjectMapper objectMapper = getInstance();

        if (nodeName == null || nodeName.equals("")) {
            nodeName = "data";
        }

        // 日期字符串替换"0000-00-00 00:00:00"、"0000-00-00"替换为null
        String contentNew = content.replaceAll("\"0000-00-00 00:00:00\"", "null").replaceAll("\"0000-00-00\"", "null");

        try {
            result = objectMapper.readValue(contentNew, valueType);

            JsonNode jsonNode = objectMapper.readTree(contentNew);
            JsonNode jsonNodeChild = jsonNode.findValue(nodeName);

            if (jsonNodeChild != null) {
                String nodeStr = jsonNodeChild.toString();
                E dataBean = objectMapper.readValue(nodeStr, beanType);
                Field field = valueType.getDeclaredField(nodeName);
                field.setAccessible(true);
                field.set(result, dataBean);
            }

        } catch (Exception e) {
            logger.error(beanType + "接口参数转换错误", e);
        }

        return result;
    }

    /**
     * 将json字符串转换为ResponseFormat<T>，T为实体bean列表。<br>
     * 
     * @param content
     * @param valueType
     * @param beanType
     * @param nodeName
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static <T, E> T readValueList(String content, Class<T> valueType, Class<E> beanType, String nodeName) {

        T result = null;

        ObjectMapper objectMapper = getInstance();

        if (nodeName == null || nodeName.equals("")) {
            nodeName = "data";
        }

        // 日期字符串替换"0000-00-00 00:00:00"、"0000-00-00"替换为null
        String contentNew = content.replaceAll("\"0000-00-00 00:00:00\"", "null").replaceAll("\"0000-00-00\"", "null");

        try {
            result = objectMapper.readValue(contentNew, valueType);

            List<E> dataBeanList = new ArrayList<E>();

            Field field = valueType.getDeclaredField(nodeName);
            field.setAccessible(true);
            Object obj = field.get(result);
            if (null != obj && obj instanceof List && ((List) obj).size() > 0) {

                for (Object objItem : ((List) obj)) {

                    // object to json
                    StringWriter writer = new StringWriter();
                    JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(writer);
                    objectMapper.writeValue(jsonGenerator, objItem);
                    jsonGenerator.close();
                    String objItemStr = writer.toString();
                    writer.close();

                    // json to bean
                    E bean = objectMapper.readValue(objItemStr, beanType);
                    dataBeanList.add(bean);
                }
            }

            if (dataBeanList.size() > 0) {
                field.set(result, dataBeanList);
            }

        } catch (Exception e) {
            logger.error(beanType + "接口参数转换错误", e);
        }

        return result;
    }
}
