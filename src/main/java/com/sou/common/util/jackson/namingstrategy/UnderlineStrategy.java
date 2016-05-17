package com.sou.common.util.jackson.namingstrategy;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;

/**
 * json命名处理
 * 
 * @author 
 * 
 */
public class UnderlineStrategy extends PropertyNamingStrategy {

    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return convert(defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return convert(defaultName);
    }

    private String convert(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, len = input.length(); i < len; ++i) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append('_');
                c = Character.toLowerCase(c);
            }
            result.append(c);
        }
        return result.toString();
    }

}
