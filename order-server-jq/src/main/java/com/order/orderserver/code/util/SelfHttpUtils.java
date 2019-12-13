package com.order.orderserver.code.util;

import com.order.orderserver.code.form.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

public class SelfHttpUtils {

    public static HttpEntity<MultiValueMap<String, Object>> mapDeal(Map<String,Object> map){
        if(map==null){
            return null;
        }
        MultiValueMap<String, Object> mmp = new LinkedMultiValueMap<String,Object>();
        for(Map.Entry mp : map.entrySet()){
            mmp.add(mp.getKey().toString(),mp.getValue());
        }
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<MultiValueMap<String, Object>>(mmp,headers);
    }

    public static void main(String[] args){
        Person p = new Person();
        p.setAge(25);
        p.setBurn(new Date());
        p.setName("Dog");
        MultiValueMap<String, Object> mmp = etyDeal(p);
        System.out.println();
    }

    public static <T> MultiValueMap<String, Object> etyDeal(T t){
        if(t==null){
            return null;
        }
        MultiValueMap<String, Object> mmp = new LinkedMultiValueMap<String,Object>();
        Class cl = t.getClass();
        Field[] fields = cl.getDeclaredFields();
        for(Field fl : fields){
            fl.setAccessible(true);
            String name = fl.getName();
            Object value = null;
            try {
                Method m = cl.getMethod("get"+name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase()));
                value = m.invoke(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mmp.add(name,value);
            System.out.println(fl.getName());
        }
        return mmp;
    }

}
