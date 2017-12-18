package cn.hang.crm.common.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lihang
 * @create 2017-11-08 下午4:11
 */
public class CollectionsUtils{
    /**
     * 提取集合中的对象的一个属性(通过Getter函数), 组合成List.
     *
     * @param collection 来源集合.
     * @param propertyName 要提取的属性名.
     */
    @SuppressWarnings("unchecked")
    public static List extractToList(final Collection collection, final String propertyName) {
        List list = new ArrayList(collection.size());
        try {
            for (Object obj : collection) {
                list.add(PropertyUtils.getProperty(obj, propertyName));
            }
        } catch (Exception e) {
            throw Reflections.convertReflectionExceptionToUnchecked(e);
        }
        return list;
    }
    /**
     * 判断是否为空.
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

}
