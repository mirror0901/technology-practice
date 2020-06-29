package com.mirror.ormtransaction.common;

import com.mirror.ormtransaction.annotation.MColumn;
import com.mirror.ormtransaction.annotation.MId;
import com.mirror.ormtransaction.utils.MStringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 提供数据库查询结果和实体类的转化
 * @create: 2020-06-23 23:15
 **/
@Component
public class InvokeClassAdapter {

    public static <T> T invokeObject(ResultSet resultSet, Class<T> clazz) {
        Map<String, Field> map = new HashMap<>(64);
        try {

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MColumn.class)) {
                    MColumn annotation = field.getAnnotation(MColumn.class);
                    String annotationColumnName = annotation.columnName() == null ? field.getName() : annotation.columnName();
                    //将注解名称和属性存放到map中
                    map.put(annotationColumnName, field);
                } else if (field.isAnnotationPresent(MId.class)) {
                    MId annotation = field.getAnnotation(MId.class);
                    map.put(field.getName(), field);
                }
            }
            T obj = clazz.getDeclaredConstructor().newInstance();
            ResultSetMetaData metaData = null;

            metaData = resultSet.getMetaData();

            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
                if (map.containsKey(columnName)) {
                    Field field = map.get(columnName);
                    Class<?> type = field.getType();
                    //获取方法名称
                    String setMethod = MStringUtils.getSetMethod(field.getName());
                    Method method = clazz.getMethod(setMethod, type);
                    Object object = resultSet.getObject(i + 1);
                    method.invoke(obj, type.cast(object));
                }
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
