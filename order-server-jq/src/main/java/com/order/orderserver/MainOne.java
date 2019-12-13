package com.order.orderserver;

import com.order.orderserver.redisConfig.Person;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class MainOne {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(22);
        list.add(12);
        list.add(25);
        list.add(9);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.valueOf(o1) - Integer.valueOf(o2);
            }
        });
        List<Person> listOb = new ArrayList<>();
        Person p1 = new Person();
        p1.setAge(12);
        p1.setName("one");
        Person p2 = new Person();
        p2.setAge(35);
        p2.setName("three");
        Person p3 = new Person();
        p3.setAge(26);
        p3.setName("two");
        listOb.add(p1);
        listOb.add(p2);
        listOb.add(p3);


        //System.out.println(list);

        //归并排序
        int[] data= {2,7,3,9,8,5,1,4,6};
        //int[] ins = sort(data);//归并排序
        //sortSelect(data);//选择排序
        //sortMaopao(data);//冒泡
        //System.out.println(data);
        //System.out.println(-1%2!=0);

        System.out.println(Integer.MAX_VALUE);
        Person person = new Person();
        Class t1 = person.getClass();
        try {
            Person ps2 = (Person) t1.newInstance();
            ps2.setAge(18);
            System.out.println(ps2.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class t2 = Person.class;
        try {
            Class t3 = Class.forName("com.order.orderserver.redisConfig.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Integer num = 0;
        Map<String,Integer> map = new HashMap<>();
        map.put("num",0);
        dealData(num,map);
        System.out.println(num);
        System.out.println(map.get("num"));

        Map<String,Object> mp1 = Collections.synchronizedMap(new HashMap<>());
        Integer i1 = 9;
        String s1 = "9";
        System.out.println(i1);

        Map<String,Object> mp2 = new HashMap<>();
        mp2.put("aa","11");
        mp2.put("cc","33");
        mp2.put("dd","44");
        mp2.put("bb","22");
        for(Map.Entry m : mp2.entrySet()){
            //System.out.println(m.getValue());
        }
        Set<String> set = new HashSet<>();
        set.add("22");
        set.add("11");
        set.add("55");
        set.add("44");
        Iterator<String> itor = set.iterator();
        while(itor.hasNext()){
            System.out.println(itor.next());
        }
    }

    public static void dealData(Integer num,Map<String,Integer> map){
        num=2;
        map.put("num",1);
    }

    //冒泡排序n*n
    public static int[] sortMaopao(int[] data){
        for(int i=data.length;i>1;i--){
            for(int j=0;j<i-1;j++){
                int one = data[j];
                int two = data[j+1];
                if(one > two){
                    data[j]=two;
                    data[j+1]=one;
                }
            }
        }
        return data;
    }

    //选择排序n*n
    public static int[] sortSelect(int[] data){
        for(int i=0;i<data.length;i++){
            for(int j=i+1;j<data.length;j++){
                int two = data[j];
                if(data[i]> two){
                    data[j]=data[i];
                    data[i]=two;
                }
            }
        }
        return data;
    }


    //归并排序 nlogn
    public static int[] sort(int[] ins){
        if(ins.length <=1){
            return ins;
        }
        int num = ins.length/2;
        int[] left = sort(Arrays.copyOfRange(ins, 0, num));
        int[] right = sort(Arrays.copyOfRange(ins, num, ins.length));
        return merge(left,right);
    }

    public static int[] merge(int[] left,int[] right){
        int l=0;
        int r=0;
        List<Integer>  list = new ArrayList<Integer>();
        while(l<left.length && r<right.length){
            if(left[l] < right[r]){
                list.add(left[l]);
                l += 1;
            }else{
                list.add(right[r]);
                r += 1;
            }
        }
        if(l>=left.length){
            for(int i=r; i<right.length; i++){
                list.add(right[i]);
            }
        }
        if(r>=right.length){
            for(int i=l; i<left.length; i++){
                list.add(left[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
