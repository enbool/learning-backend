package io.github.enbool.dict.utils;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.github.enbool.dict.exception.BusinessErrorEnum;
import io.github.enbool.dict.exception.BusinessException;
import io.github.enbool.dict.exception.ErrorCode;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author wumin
 * @Description: assert util
 * @date 2023年4月10日 11:31:51
 */
public class AssertUtils {

    /** email的正则表达式 **/
    private static final String REGULAR_EXPRESSION_EMAIL =
        "^[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,4})$";

    /** phone的正则表达式 **/
    private static final String REGULAR_EXPRESSION_PHONE = "^[- +*\\d]+$";

    /** 中国手机的正则表达式 */
    private static final String REGULAR_EXPRESSION_CHINE_MOBILE_PHONE =
        "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    /** 密码最小长度 */
    private static final int MIN_LENGTH_PASSWORD = 3;

    /** 密码中最大的相同字符长度 */
    private static final int MAX_SIZE_SAME_CHARACTER_PASSWORD = 3;

    /**
     * Assert that an object is not {@code null}.
     *
     * <pre class="code">
     * Assert.notNull(clazz, "The class must not be null");
     * </pre>
     *
     * @param object
     *            the object to check
     * @param format
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if the object is {@code null}
     */
    public static void notNull(Object object, ErrorCode errorCode, String format, Object... messageParams) {
        if (object == null) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * @param object
     * @param errorCode
     */
    public static void notNull(Object object, ErrorCode errorCode) {
        notNull(object, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that an object is {@code null}.
     *
     * <pre class="code">
     * Assert.requireNull(clazz, "The class must be null");
     * </pre>
     *
     * @param object
     *            the object to check
     * @param format
     *            the exception message to use if the assertion fails
     */
    public static void requireNull(Object object, ErrorCode errorCode, String format, Object... messageParams) {
        if (Objects.nonNull(object)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that an object is {@code null}.
     *
     * @param object
     * @param errorCode
     */
    public static void requireNull(Object object, ErrorCode errorCode) {
        requireNull(object, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that an array contains elements; that is, it must not be {@code null} and must contain at least one
     * element.
     *
     * <pre class="code">
     * Assert.notEmpty(array, "The array must contain elements");
     * </pre>
     *
     * @param array
     *            the array to check
     * @param message
     *            the exception message to use if the assertion fails
     * @throws BusinessException
     *             if the object array is {@code null} or contains no elements
     */
    public static void notEmpty(Object[] array, String message, ErrorCode errorCode, String format,
        Object... messageParams) {
        if (array == null || array.length == 0) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that an array contains elements; that is, it must not be {@code null} and must contain at least one
     * element.
     *
     * <pre class="code">
     * Assert.notEmpty(array, "The array must contain elements");
     * </pre>
     *
     * @param array
     *            the array to check
     * @throws BusinessException
     *             if the object array is {@code null} or contains no elements
     */
    public static void notEmpty(Object[] array, ErrorCode errorCode) {
        notEmpty(array, "", errorCode, errorCode.getDescription());
    }

    /**
     * Assert that a collection contains elements; that is, it must not be {@code null} and must contain at least one
     * element.
     *
     * <pre class="code">
     * Assert.notEmpty(collection, "Collection must contain elements");
     * </pre>
     *
     * @param collection
     *            the collection to check
     * @param format
     *            the exception message to use if the assertion fails
     * @throws BusinessException
     *             if the collection is {@code null} or contains no elements
     */
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode, String format, Object... messageParams) {
        if (collection == null || collection.isEmpty()) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that a map contains elements; that is, it must not be {@code null} and must contain at least one element.
     *
     * <pre class="code">
     * Assert.notEmpty(map, "Map must contain elements");
     * </pre>
     *
     * @param map
     *            the map to check
     * @param format
     *            the exception message to use if the assertion fails
     * @throws BusinessException
     *             if the map is {@code null} or contains no elements
     */
    public static void notEmpty(Map map, ErrorCode errorCode, String format, Object... messageParams) {
        if (map == null || map.isEmpty()) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that a map contains elements; that is, it must not be {@code null} and must contain at least one element.
     *
     * <pre class="code">
     * Assert.notEmpty(map, "Map must contain elements");
     * </pre>
     *
     * @param map
     *            the map to check
     * @param errorCode
     *            the errorCode to use if the assertion fails
     * @throws BusinessException
     *             if the map is {@code null} or contains no elements
     */
    public static void notEmpty(Map map, ErrorCode errorCode) {
        notEmpty(map, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that a collection contains elements; that is, it must not be {@code null} and must contain at least one
     * element.
     *
     * <pre class="code">
     * Assert.notEmpty(collection, "Collection must contain elements");
     * </pre>
     *
     * @param collection
     *            the collection to check
     * @throws BusinessException
     *             if the collection is {@code null} or contains no elements
     */
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode) {
        notEmpty(collection, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that a map with no elements; that is, it must be {@code null} or does not contain any element.
     *
     * <pre class="code">
     * Assert.notEmpty(map, "Map must be null or does not contain any element");
     * </pre>
     *
     * @param map
     *            the map to check
     * @param format
     *            the errorCode message to use if the assertion fails
     * @throws BusinessException
     *             if the collection contains any elements
     */
    public static void requireEmpty(Map map, ErrorCode errorCode, String format, Object... messageParams) {
        if (map != null && !map.isEmpty()) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that a map with no elements; that is, it must be {@code null} or does not contain any * element.
     *
     * @param map
     *            the map to check
     * @param errorCode
     *
     * @throws BusinessException
     *             if the map contains any elements
     */
    public static void requireEmpty(Map map, ErrorCode errorCode) {
        requireEmpty(map, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that a collection with no elements; that is, it must be {@code null} or does not contain any element.
     *
     * <pre class="code">
     * Assert.notEmpty(collection, "Collection must be null or does not contain any element");
     * </pre>
     *
     * @param collection
     *            the collection to check
     * @param format
     *            the exception message to use if the assertion fails
     * @throws BusinessException
     *             if the collection contains any elements
     */
    public static void requireEmpty(Collection<?> collection, ErrorCode errorCode, String format,
        Object... messageParams) {
        if (CollectionUtils.isNotEmpty(collection)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that a collection with no elements; that is, it must be {@code null} or does not contain any * element.
     *
     * @param collection
     *            the collection to check
     * @throws BusinessException
     *             if the collection contains any elements
     */
    public static void requireEmpty(Collection<?> collection, ErrorCode errorCode) {
        requireEmpty(collection, errorCode, errorCode.getDescription());
    }

    /**
     * Assert that a collection contains no elements; that is, it must be {@code null} and must not contain one element.
     *
     * @param collection
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void empty(Collection<?> collection, ErrorCode errorCode, String format, Object... messageParams) {
        if (collection != null && !collection.isEmpty()) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * Assert that an array contains elements; that is, it must not be {@code null} and must contain at least one
     * element.
     *
     * <pre class="code">
     * Assert.notEmpty(array, "The array must contain elements");
     * </pre>
     *
     * @param str
     *            the array to check
     * @param format
     *            the exception message to use if the assertion fails
     * @throws BusinessException
     *             if the object array is {@code null} or contains no elements
     */
    public static void notBlank(String str, ErrorCode errorCode, String format, Object... messageParams) {
        if (org.apache.commons.lang3.StringUtils.isBlank(str)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * @param str
     * @param errorCode
     */
    public static void notBlank(String str, ErrorCode errorCode) {
        notBlank(str, errorCode, errorCode.getDescription());
    }

    /**
     * @param condition
     * @param format
     */
    public static void isTrue(boolean condition, ErrorCode errorCode, String format, Object... messageParams) {
        if (!condition) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * @param condition
     * @param errorCode
     */
    public static void isTrue(boolean condition, ErrorCode errorCode) {
        isTrue(condition, errorCode, errorCode.getDescription());
    }

    /**
     * 断言结果必须是false
     *
     * @param condition
     * @param format
     */
    public static void isFalse(boolean condition, ErrorCode errorCode, String format, Object... messageParams) {
        if (condition) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * @param condition
     * @param errorCode
     */
    public static void isFalse(boolean condition, ErrorCode errorCode) {
        isFalse(condition, errorCode, errorCode.getDescription());
    }

    /**
     * 断言两个字符串是否相等，如果不等则抛异常
     * 
     * @param str1
     *            字符串1
     * @param str2
     *            字符串2
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void isEquals(String str1, String str2, ErrorCode errorCode, String format, Object... messageParams) {
        if (!StringUtils.equals(str1, str2)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 断言两个字符串是否相等，如果不等则抛异常
     * 
     * @param str1
     *            字符串1
     * @param str2
     *            字符串2
     * @param errorCode
     */
    public static void isEquals(String str1, String str2, ErrorCode errorCode) {
        isEquals(str1, str2, errorCode, errorCode.getDescription());
    }

    /**
     * 断言两个字符串是否不等，如果相等则抛异常
     *
     * @param str1
     *            字符串1
     * @param str2
     *            字符串2
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void notEquals(String str1, String str2, ErrorCode errorCode, String format,
        Object... messageParams) {
        if (StringUtils.equals(str1, str2)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 断言两个字符串是否不等，如果相等则抛异常
     *
     * @param str1
     *            字符串1
     * @param str2
     *            字符串2
     * @param errorCode
     */
    public static void notEquals(String str1, String str2, ErrorCode errorCode) {
        notEquals(str1, str2, errorCode, errorCode.getDescription());
    }

    /**
     * 判断其中一个数bigger是否比另外一个数smaller大，如果bigger小于等于smaller，则抛异常
     * 
     * @param bigger
     *            较大的数（Long）
     * @param smaller
     *            较小的数（Long）
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void biggerThan(Long bigger, Long smaller, ErrorCode errorCode, String format,
        Object... messageParams) {
        if (bigger == null || smaller == null) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
        if (bigger <= smaller) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 判断其中一个数bigger是否比另外一个数smaller大，如果bigger小于等于smaller，则抛异常
     * 
     * @param bigger
     *            较大的数（Integer）
     * @param smaller
     *            较小的数（Integer）
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void biggerThan(Integer bigger, Integer smaller, ErrorCode errorCode, String format,
        Object... messageParams) {
        if (bigger == null || smaller == null) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
        if (bigger <= smaller) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param strNum
     * @return
     */
    public static void isNumber(String strNum, ErrorCode errorCodeEnum) {
        for (char num : strNum.toCharArray()) {
            if (!Character.isDigit(num) && num != '*') {
                throw new BusinessException(errorCodeEnum);
            }
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param strNum
     * @return
     */
    public static void isNumber(String strNum, ErrorCode errorCodeEnum, String format, Object... messageParams) {
        for (char num : strNum.toCharArray()) {
            if (!Character.isDigit(num) && num != '*') {
                throw new BusinessException(errorCodeEnum, String.format(format, messageParams));
            }
        }
    }

    /**
     * 是否是英文
     * 
     * @param keyWord
     * @return
     */
    public static boolean isEnglishWord(String keyWord) {
        // 判断字符串是否全为英文字母，是则返回true
        return keyWord.matches("[a-zA-Z]+");
    }

    /**
     * 当然始字符串是否要给定的最小长度min和最大长度max范围内。如果恰好等于最小长度和最大长度也可以
     * 
     * @param origin
     *            原始字符串
     * @param minLength
     *            最小长度
     * @param maxLength
     *            最大长度
     * @param errorCode
     *            异常码
     * @param format
     *            错误信息1
     * @param messageParam
     *            错误信息2
     */
    public static void strLength(String origin, int minLength, int maxLength, ErrorCode errorCode, String format,
        Object... messageParam) {
        if (minLength < 0) {
            minLength = 0;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(origin) && minLength == 0) {
            return;
        }
        if (maxLength < 0 || minLength > maxLength) {
            throw new BusinessException(BusinessErrorEnum.PARAM_INVALID_ERROR);
        }
        if (minLength > 0) {
            notBlank(origin, errorCode, format, messageParam);
        }
        if (origin.length() > maxLength || origin.length() < minLength) {
            throw new BusinessException(errorCode, String.format(format, messageParam));
        }

    }

    /**
     * 是否是email
     * 
     * @param email
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void isEmail(String email, ErrorCode errorCode, String format, Object... messageParams) {
        notBlank(email, errorCode, format, messageParams);
        if (!email.matches(REGULAR_EXPRESSION_EMAIL)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 是否是密码校验。密码必须以下规则： 1、必须是数字、大小写字母、特征符号的组合 2、最小长度为3 3、不能包括sensetime、sensexperience等字符 4、不能包括连续的字符，如123
     * 
     * @param password
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void isPassword(String password, ErrorCode errorCode, String format, Object... messageParams) {
        if (org.apache.commons.lang3.StringUtils.isBlank(password) || password.length() < MIN_LENGTH_PASSWORD) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
        int strength = 0;
        List<String> regexs = Arrays.asList("^.*\\d+.*$", "^.*[a-z]+.*$", "^.*[A-Z]+.*$", "^.*\\W+.*$");
        for (String regex : regexs) {
            if (password.matches(regex)) {
                strength++;
            }
        }
        if (strength < regexs.size()) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 是否是中国手机号
     * 
     * @param phone
     * @param errorCode
     * @param format
     * @param messageParams
     */
    public static void isChinesePhone(String phone, ErrorCode errorCode, String format, Object... messageParams) {
        notBlank(phone, errorCode, format, messageParams);
        if (!phone.matches(REGULAR_EXPRESSION_CHINE_MOBILE_PHONE)) {
            throw new BusinessException(errorCode, String.format(format, messageParams));
        }
    }

    /**
     * 是否是电话
     * 
     * @param phone
     * @param errorCode
     */
    public static void isPhone(String phone, ErrorCode errorCode) {
        if (!phone.matches(REGULAR_EXPRESSION_PHONE)) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * 是否是数字或者英文字母
     * 
     * @param value
     * @param errorCode
     */
    public static void isNumberOrEnglishWord(String value, ErrorCode errorCode) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(value).matches()) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * 英文名称只能有英文字母与空格
     *
     * @param enName
     * @param errorCode
     */
    public static void isEnglishName(String enName, ErrorCode errorCode) {
        notBlank(enName, errorCode, "enName not blank", "");
        String regex = "^[A-Za-z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(enName).matches()) {
            throw new BusinessException(errorCode);
        }
    }

}
