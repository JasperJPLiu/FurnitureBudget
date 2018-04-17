package com.edu.zucc.service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListToMap {
    public static class DemoClass {
        private Integer id;
        private String name;

        public DemoClass() {
        }

        public DemoClass(Integer id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static <K, V> Map<K, V> list2Map(List<V> list, String fieldName4Key, Class<V> c) {
        Map<K, V> map = new HashMap<K, V>();
        if (list != null) {
            try {
                PropertyDescriptor propDesc = new PropertyDescriptor(fieldName4Key, c);
                Method methodGetKey = propDesc.getReadMethod();
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }

        return map;
    }

    public static Map<Integer, DemoClass> traditionalWay(List<DemoClass> list) {
        Map<Integer, DemoClass> map = new HashMap<Integer, DemoClass>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                DemoClass value = list.get(i);
                map.put(value.getId(), value);
            }
        }

        return map;
    }
}
