package com.sou.common.util.jackson;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sou.common.util.jackson.namingstrategy.PropertyTranslateStrategy;
import com.sou.common.util.jackson.namingstrategy.UnderlineFilterStrategy;
import com.sou.common.util.jackson.serialize.JackJsonNamingFormat;

public class JackJsonUtil {
    public static boolean checkFiledFlag = true;
    public static final String filterKey = "filter";
    private static final Logger LOG = LoggerFactory.getLogger(JackJsonUtil.class);

    /**
     * json 字符串转换成beanlist
     * 
     * @param json
     * @param typeReference
     * @return
     * @throws IOException
     */
    /*public static List<?> toBeanList(String json, TypeReference<?> typeReference, Object... configObj) {
        if(json==null){
            return null;
        }
        List<?> beanList = new ArrayList<Object>(0);
        StringBuffer sbf = new StringBuffer(0);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper = setMapperConfig(mapper, configObj);
            beanList = mapper.readValue(json, typeReference);
        } catch (Exception e) {
            LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json).toString(), e);
        }
        return beanList;
    }*/
    public static <T> List<T> toBeanList(String json, TypeReference<List<T>> typeReference, Object... configObj) {
        if(json==null){
            return null;
        }
        List<T> beanList = null;
        StringBuffer sbf = new StringBuffer(0);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper = setMapperConfig(mapper, configObj);
            beanList = mapper.readValue(json, typeReference);
        } catch (Exception e) {
            LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json).toString(), e);
        }
        return beanList;
    }
	/**
	 * json转换成对象
	 * 
	 * @param json
	 * @param classObj
	 * @param configObj
	 * @return
	 */
	public static <T> T toBean(String json, TypeReference<T> typeReference,
			Object... configObj) {
        if(json==null){
            return null;
        }
		ObjectMapper mapper = new ObjectMapper();
		mapper = setMapperConfig(mapper, configObj);
		StringBuffer sbf = new StringBuffer(0);
		try {
			return (T) mapper.readValue(json, typeReference);
		} catch (Exception e) {
			LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json)
					.toString(), e);
		}
		return null;
	}
	
	/**
	 * json转换成对象
	 * 
	 * @param json
	 * @param classObj
	 * @param configObj
	 * @return
	 */
	public static <T> T toBean(String json, Class<T> classObj,
	        Object... configObj) {
        if(json==null){
            return null;
        }
	    ObjectMapper mapper = new ObjectMapper();
	    mapper = setMapperConfig(mapper, configObj);
	    StringBuffer sbf = new StringBuffer(0);
	    try {
	        return mapper.readValue(json, classObj);
	    } catch (Exception e) {
	        LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json)
	                .toString(), e);
	    }
	    return null;
	}

	public static <T> T toBeanThrowE(String json, Class<T> classObj,
	        Object... configObj) throws JsonParseException, JsonMappingException, IOException {
        if(json==null){
            return null;
        }
	    ObjectMapper mapper = new ObjectMapper();
	    mapper = setMapperConfig(mapper, configObj);
	    return mapper.readValue(json, classObj);
	}
	
    /**
     * 设置jackjson 配置
     * 
     * @param mapper
     * @param configObj
     * @return
     */
    @SuppressWarnings("unchecked")
    private static ObjectMapper setMapperConfig(ObjectMapper mapper, Object... configObj) {
        Set<String> fliterSet = new HashSet<String>(0);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        if (checkFiledFlag) {
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        if (configObj != null && configObj.length == 1 && configObj[0] instanceof Set) {
            fliterSet = (Set<String>) configObj[0];
            FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterKey,
                    SimpleBeanPropertyFilter.serializeAllExcept(fliterSet));
            mapper.setFilters(filterProvider);
        } else if (configObj != null && configObj.length == 1 && configObj[0] instanceof PropertyNamingStrategy) {
            if (configObj[0] instanceof UnderlineFilterStrategy) {
                UnderlineFilterStrategy strategy = (UnderlineFilterStrategy) configObj[0];
                FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterKey,
                        SimpleBeanPropertyFilter.serializeAllExcept(strategy.getFilterSet()));
                mapper.setFilters(filterProvider);
            } else if (configObj[0] instanceof PropertyTranslateStrategy) {
                PropertyTranslateStrategy strategy = (PropertyTranslateStrategy) configObj[0];
                JackJsonNamingFormat format = strategy.getJackJsonNamingFormat();
                if (format != null) {
                    fliterSet = format.getFilterSet();
                }
                FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterKey,
                        SimpleBeanPropertyFilter.serializeAllExcept(fliterSet));
                mapper.setFilters(filterProvider);
            }
            mapper.setPropertyNamingStrategy((PropertyNamingStrategy) configObj[0]);
		} else if (configObj != null && configObj.length == 1 && configObj[0] instanceof DateFormat) {
			mapper.setDateFormat((DateFormat) configObj[0]);
		} else {
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterKey,
					SimpleBeanPropertyFilter.serializeAllExcept(fliterSet));
			mapper.setFilters(filterProvider);

		}
        return mapper;
    }

    /**
     * json 转换成HashMap
     * 
     * @param json
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static Map<Object, Object> toHashMap(String json, Object... configObj) {
        if(json==null){
            return null;
        }
        HashMap<Object, Object> bean = null;
        StringBuffer sbf = new StringBuffer(0);
        ObjectMapper mapper = new ObjectMapper();
        mapper = setMapperConfig(mapper, configObj);
        try {
            bean = mapper.readValue(json, HashMap.class);
        } catch (Exception e) {
            LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json).toString(), e);
        }
        return bean;
    }

    /**
     * json串转化为map对象
     * 
     * @param json
     *            json串
     * @return 成功返回一个map，失败则返回一个emptyMap
     */
    public static <K, V> Map<K, V> toMap(String json) {
        if(json==null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper = setMapperConfig(mapper);
        StringBuffer sbf = new StringBuffer(0);
        try {
            return mapper.readValue(json, new TypeReference<Map<K, V>>() {
            });
        } catch (Exception e) {
            LOG.error(sbf.append(" JackjsonUtil deserialize {}, exception is:{}").toString(), json, e);
        }
        return Collections.emptyMap();
    }

    /**
     * 转换成泛型 hashMap
     * 
     * @param json
     * @param typeReference
     * @param configObj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T toHashMap(String json, TypeReference<?> typeReference, Object... configObj) {
        if(json==null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        StringBuffer sbf = new StringBuffer(0);
        try {
            mapper = setMapperConfig(mapper, configObj);
            return (T) mapper.readValue(json, typeReference);
        } catch (Exception e) {
            LOG.error(sbf.append(" JackjsonUtil deserialize ").append(json).toString(), e);
        }
        return null;
    }

    /**
     * 对象转换成Map
     * 
     * @param obj
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static HashMap converToMap(Object obj, Object... configObj) {
        if (obj == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper = setMapperConfig(mapper, configObj);
        return mapper.convertValue(obj, HashMap.class);
    }

    /**
     * 对象转换成json
     * 
     * @param obj
     * @return
     */
    public static String toJson(Object obj, Object... configObj) {
        ObjectMapper mapper = new ObjectMapper();
        String retJson = "";
        if (obj == null) {
            return retJson;
        }
        mapper = setMapperConfig(mapper, configObj);
        try {
            retJson = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            LOG.error(" JackjsonUtil serialize error", e);
        }
        return retJson;
    }
    
}
