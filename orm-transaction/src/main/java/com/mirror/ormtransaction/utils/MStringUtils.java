package com.mirror.ormtransaction.utils;

import com.mirror.ormtransaction.annotation.MColumn;
import com.mirror.ormtransaction.annotation.MId;
import com.mirror.ormtransaction.annotation.MTable;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 自定义工具类
 * @create: 2020-06-22 02:01
 **/
public class MStringUtils {

    /**
     * 将第一个字母替换为大写
     *
     * @param str
     * @return
     */
    public static String firstUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }

    /**
     * 获取属性的set方法
     *
     * @param fieldName
     * @return
     */
    public static String getSetMethod(String fieldName) {
        return "set" + firstUpperCase(fieldName);
    }

    /**
     * 根据实体名获取表名称
     *
     * @param clazz
     * @return
     */
    public static String getTableName(Class<?> clazz) {
        String tableName = clazz.getSimpleName();
        if (null != clazz) {
            //判断是否加载了自定义注解
            if (clazz.isAnnotationPresent(MTable.class)) {
                MTable annotation = clazz.getAnnotation(MTable.class);
                tableName = annotation.tableName();
            }
        }
        return tableName;
    }

    /**
     * 根据属性名称获取字符名称
     *
     * @param field
     * @return
     */
    public static String getTableFieldName(Field field) {
        String fieldName = "";
        if (null != field) {
            if (field.isAnnotationPresent(MColumn.class)) {
                MColumn annotation = field.getAnnotation(MColumn.class);
                if (!Objects.equals("", annotation)) {
                    fieldName = annotation.columnName();
                }
            } else if (!field.isAnnotationPresent(MId.class)) {
                fieldName = field.getName();
            }
        }
        return fieldName;
    }

    /**
     * 根据字段获取主键的名称
     *
     * @param field
     * @return
     */
    public static String getTableIdName(Field field) {
        String idName = "";
        if (null != field) {
            if (field.isAnnotationPresent(MId.class)) {
                MId annotation = field.getAnnotation(MId.class);
                if (!Objects.equals("", annotation)) {
                    idName = annotation.idName();
                }
            } else {
                idName = field.getName();
            }
        }
        return idName;
    }

}
