package io.github.enbool.dict.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.exception.BusinessException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/28 14:44
 */
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        getMapper().configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        getMapper().findAndRegisterModules();
        getMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    private JsonUtils() {}

    public static ObjectMapper getMapper() {
        return OBJECT_MAPPER;
    }

    /**
     * 实体对象转换成Json字符串
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJsonString(T t) {
        try {
            return getMapper().writeValueAsString(t);
        } catch (Exception e) {
            throw new BusinessException(e, BusinessErrorEnum.JSON_SERIALIZE_ERROR);
        }
    }

    /**
     * Json字符串转换成实体对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parse2Object(String json, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(json)) {
                return null;
            }
            return getMapper().readValue(json.getBytes(StandardCharsets.UTF_8), clazz);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s", json);
        }
    }

    /**
     * Json字符串转换成List
     *
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> parse2List(String jsonStr, Class<T> t) {
        if (StringUtils.isBlank(jsonStr)) {
            return Collections.emptyList();
        }
        JavaType javaType = getMapper().getTypeFactory().constructParametricType(List.class, t);
        try {
            return getMapper().readValue(jsonStr, javaType);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * Json字符串转换成实体对象
     *
     * @param jsonStr
     *            json字符串
     * @param valueType
     *            需要指定转换的对象类型 示例：new TypeReference<指定的对象类型>(){}
     * @param <T>
     *            泛型
     * @return
     */
    public static <T> T parse2Object(String jsonStr, TypeReference<T> valueType) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        getMapper().configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        getMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return (T)getMapper().readValue(jsonStr.getBytes(StandardCharsets.UTF_8), valueType);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * 获取jsonNode对象
     *
     * @param jsonStr
     * @return
     */
    public static JsonNode getJsonNode(String jsonStr) {
        try {
            return getMapper().readTree(jsonStr);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * 判断某个json字符串是否含有某个key
     *
     * @param json
     * @param key
     * @param recursion
     *            是否递归遍历，否则只会查找当前节点的下一层
     * @return
     */
    public static boolean containsKey(String json, String key, boolean recursion) {
        JsonNode rootJsonNode = getJsonNode(json);
        return containsKey(rootJsonNode, key, recursion);
    }

    /**
     * 判断某个jsonNode字符串是否含有某个key
     *
     * @param jsonNode
     * @param key
     * @param recursion
     *            是否递归遍历，否则只会查找当前节点的下一层
     * @return
     */
    public static boolean containsKey(JsonNode jsonNode, String key, boolean recursion) {
        Iterator<Map.Entry<String, JsonNode>> jsonNodes = jsonNode.fields();
        while (jsonNodes.hasNext()) {
            Map.Entry<String, JsonNode> entry = jsonNodes.next();
            if (entry.getKey().equals(key)) {
                return true;
            } else if (recursion) {
                return containsKey(entry.getValue(), key, true);
            }
        }
        return false;
    }

    /**
     * 将str转化成map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> getMap(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return new HashMap<>(0);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr, HashMap.class);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * 将str转化成map,并获取其中key的值
     *
     * @param strJson
     * @return
     */
    public static Object getValue(String jsonStr, String key) {
        try {
            Map<String, Object> map = getMap(jsonStr);
            return map.get(key);
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * 将str转化成map,并获取其中key的值，且转化为String（如果不存在则返回null)
     *
     * @param strJson
     * @return
     */
    public static String getStrValue(String jsonStr, String key) {
        try {
            Map<String, Object> map = getMap(jsonStr);
            Object value = map.get(key);
            if (Objects.nonNull(value)) {
                return value.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new BusinessException(BusinessErrorEnum.JSON_SERIALIZE_ERROR, "json deserialized error. json=%s",
                    jsonStr);
        }
    }

    /**
     * 为strJson中按json格式增加一个key-valud对。如果原来已经存在key，则会替换原来的值
     *
     * @param strJson
     * @return
     */
    public static String addValue(String strJson, String key, Object value) {
        if (StringUtils.isBlank(key)) {
            return strJson;
        }
        Map<String, Object> map = getMap(strJson);
        // if(!StringUtils.isBlank(strJson)){
        // map = getMap(strJson);
        // }
        map.put(key, value);
        return toJsonString(map);
    }

    /**
     * Date类型的序列化器
     */
    public static class DateTimeSerializer extends JsonSerializer<Date> {
        private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (value == null) {
                return;
            }
            Instant instant = value.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            String text = localDateTime.format(formatter);
            gen.writeString(text);
        }

    }

}
