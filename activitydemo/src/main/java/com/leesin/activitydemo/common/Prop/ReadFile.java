package com.leesin.activitydemo.common.Prop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Set;

/**
 * 获取配置信息的帮助类。
 * @author LiuBo
 *
 */
public abstract class ReadFile {

    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(ReadFile.class);

    /**
     * 配置文件默认路径
     * 注:资源文件如果在jar中,需指定相对路径;
     * 资源文件如果在工程中，则无需指定路径 .
     * */
//	protected static final String PATH_DEFAULT = "resources/prop-config.properties";
    protected static final String PATH_DEFAULT = "demo.properties";

    /**
     * 初始化锁
     */
    protected static final Object LOCK = new Object();

    /**
     * 存放键值对的Properties
     */
    protected static volatile Properties properties;

    /** 是否已经初始化 */
    protected static boolean initialized = false;

    /**
     * 已制定的路径进行初始化配置信息。
     * @param path 配置文件所在的路径。
     */
    protected static void load(String path) {
        synchronized (LOCK) {
            try {
                properties = ResourcesHelper.getResourceAsProperties(path);
                if (log.isDebugEnabled()) {
                    Set<Object> keys = properties.keySet();
                    for (Object key : keys) {
                        Object value = properties.get(key);
                        log.info(key + " : " + value);
                    }
                }
                initialized = true;
            } catch (Exception e) {
                log.warn(path, e);
            }
        }
    }

    /**
     * 根据指定的键获取字符串。
     *
     * @param key
     *            键
     * @return 返回字符串。
     */
    public static String getString(String key) {
        if (properties == null) {
            if (!initialized) {
                synchronized (LOCK) {
                    if (!initialized) {
                        load(PATH_DEFAULT);
                    }
                }
            }
        }
        return properties.getProperty(key);
    }

    /**
     * 根据指定的键和默认值获取字符串，如果没有返回默认值。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值
     * @return 返回字符串。
     */
    public static String getString(String key, String defaultValue) {
        if (properties == null) {
            if (!initialized) {
                synchronized (LOCK) {
                    if (!initialized) {
                        load(PATH_DEFAULT);
                    }
                }
            }
        }
        return properties.getProperty(key, defaultValue);
    }

    /**
     * 根据指定的键获取正数。
     *
     * @param key
     *            键
     * @return 返回正数。
     */
    public static Integer getInteger(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Integer.valueOf(value);
    }

    /**
     * 根据指定的键和默认值获取正数。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值
     * @return 返回正数
     */
    public static Integer getInteger(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Integer.valueOf(value);
    }

    /**
     * 根据指定的键获取长正数。
     *
     * @param key
     *            键
     * @return 返回长正数。
     */
    public static Long getLong(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Long.valueOf(value);
    }

    /**
     * 根据指定的键和默认值获取长整数。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值
     * @return 返回长整数。
     */
    public static Long getLong(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Long.valueOf(value);
    }

    /**
     * 根据指定的键获取布尔值。
     *
     * @param key
     *            键
     * @return 返回布尔值。
     */
    public static Boolean getBoolean(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Boolean.valueOf(value);
    }

    /**
     * 根据指定的键和默认值获取布尔值。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值
     * @return 返回布尔值。
     */
    public static Boolean getBoolean(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Boolean.valueOf(value);
    }

    /**
     * 根据指定的键和默认值获取BigDecimal。
     *
     * @param key
     *            键
     * @return 返回BigDecimal。
     */
    public static BigDecimal getBigDecimal(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return new BigDecimal(value);
    }

    /**
     * 根据指定的键和默认值获取BigDecimal。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值。
     * @return 返回BigDecimal。
     */
    public static BigDecimal getBigDecimal(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return new BigDecimal(value);
    }

    /**
     * 根据指定的键获取Double。
     *
     * @param key
     *            键
     * @return 返回Double。
     */
    public static Double getDouble(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Double.valueOf(value);
    }

    /**
     * 根据指定的键和默认值获取Double。
     *
     * @param key
     *            键
     * @param defaultValue
     *            默认值
     * @return 返回Double。
     */
    public static Double getDouble(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Double.valueOf(value);
    }

    public static Byte getByte(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Byte.valueOf(value);
    }

    public static Byte getByte(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Byte.valueOf(value);
    }

    public static Short getShort(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Short.valueOf(value);
    }

    public static Short getShort(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Short.valueOf(value);
    }

    public static Float getFloat(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return Float.valueOf(value);
    }

    public static Float getFloat(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return Float.valueOf(value);
    }

    public static BigInteger getBigInteger(String key) {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return new BigInteger(value);
    }

    public static BigInteger getBigInteger(String key, String defaultValue) {
        String value = getString(key, defaultValue);
        return new BigInteger(value);
    }
}
