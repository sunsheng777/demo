package com.sunsheng.common.utils;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CollectionsUtils {

    private CollectionsUtils() {
    }

    public static boolean isNull(Collection c){
        if(c==null || c.size()==0){
            return true;
        }return false;
    }

    public static boolean isNull(Map m){
        if(m==null || m.size()==0){
            return true;
        }return false;
    }

    public static boolean isNotNull(Collection c){
        return !CollectionsUtils.isNull(c);
    }

    public static boolean isNotNull(Map m){
        return !CollectionsUtils.isNull(m);
    }

    //交集
    public static <T> Collection<T> intersect(Collection<T> c1 , Collection<T> c2){
        Set<T> result= new HashSet<>();//result.clear();
        if(c1 == null){
            c1 = new HashSet<>();
        }
        if(c2 == null){
            c2 = new HashSet<>();
        }
        result.addAll(c1);
        result.retainAll(c2);
        return result;
    }
    //差集
    public static <T> Collection<T> difference(Collection<T> c1 , Collection<T> c2){
        Set<T> result= new HashSet<>();
        if(c1 == null){
            c1 = new HashSet<>();
        }
        if(c2 == null){
            c2 = new HashSet<>();
        }
        result.addAll(c1);
        result.removeAll(c2);
        return result;
    }
    //并集
    public static <T> Collection<T> union(Collection<T> c1 , Collection<T> c2){
        Set<T> result= new HashSet<>();
        if(c1 == null){
            c1 = new HashSet<>();
        }
        if(c2 == null){
            c2 = new HashSet<>();
        }
        result.addAll(c1);
        result.addAll(c2);
        return result;
    }

    //测试代码
    public static void main(String[] args) {
        /*Set<P> set1 = new HashSet<P>() {{
            add(new P(1));
            add(new P(3));
            add(new P(5));
        }};
        Set<P> set2 = new HashSet<P>() {{
            add(new P(1));
            add(new P(2));
            add(new P(3));
        }};
        System.out.println("交集：" + CollectionsUtils.intersect(set1,set2));

        System.out.println("差集：" + CollectionsUtils.difference(set1,set2));

        System.out.println("并集：" + CollectionsUtils.union(set1,set2));*/

        /*List<P> list1 = new ArrayList<P>() {{
            add(new P(1));
            add(new P(3));
            add(new P(5));
        }};
        List<P> list2 = new ArrayList<P>() {{
            add(new P(1));
            add(new P(2));
            add(new P(3));
        }};
        System.out.println("交集：" + CollectionsUtils.intersect(list1,list2));

        System.out.println("差集：" + CollectionsUtils.difference(list1,list2));

        System.out.println("并集：" + CollectionsUtils.union(list1,list2));*/

        List<P> list2 = new ArrayList<P>() {{
            add(new P(1));
            add(new P(2));
            add(new P(3));
            add(new P(4));
            add(new P(5));
        }};
//        List<P> reject = CollectionsUtils.reject(list2, p -> p.id > 2 && p.id <= 4);
//        System.out.println(list2);
//        System.out.println(reject);

//        List<P> select = CollectionsUtils.select(list2, p -> p.id > 2 && p.id <= 4);
//        System.out.println(list2);
//        System.out.println(select);

//        List<P> collection = CollectionsUtils.getEmptyCollection(ArrayList.class);
//        collection.add(new P(18));
//        System.out.println(collection);
        Map<Integer,P> map = new HashMap<>();
        map.put(1,new P(1));
        map.put(2,new P(2));
        map.put(3,new P(3));
        map.put(4,new P(4));
        map.put(5,new P(5));
        Map<Integer, P> select = CollectionsUtils.select(map, (k, p) -> p.id < 2 || p.id >= 4);
        System.out.println(map);
        System.out.println(select);


    }

    public static<C> C getEmptyCollection(Class<C> clazz){
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static<C extends Collection<T> ,T> C returnCollection(C c,Class<? extends Collection> collectionClass, Predicate<T> f,boolean need){
        if(c == null){
            return null;
        }
        C result = (C) CollectionsUtils.getEmptyCollection(collectionClass);
        for (T t:c) {
            boolean where = need ? f.test(t) : !f.test(t);
            if(where) result.add(t);
        }
        return result;
    }

    //返回不满足代码块的元素数组
    public static<C extends Collection<T> ,T> C reject(C c, Predicate<T> f){
        return returnCollection(c, ArrayList.class, f,false);
    }

    //根据条件返回一个子集
    public static<C extends Collection<T>,T> C select(C c, Predicate<T> f){
        return returnCollection(c, ArrayList.class, f,true);
    }
    //根据条件返回一个子集
    public static<M extends Map<K,T>,T,K> M select(M m, BiPredicate<K,T> f){
        if(m == null){
            return null;
        }
        M result = (M) CollectionsUtils.getEmptyCollection(HashMap.class);
        for (K k:m.keySet()) {
            if(f.test(k,m.get(k))) result.put(k,m.get(k));
        }
        return result;
    }

    //测试类
    static class P{
        private int id;

        P(int id){this.id=id;}

        public boolean equals(Object p){
            if(((P)p).id==this.id){
                return true;
            }else{
                return false;
            }
        }
        public int hashCode(){
            return id;
        }

        public String toString(){
            return id+"";
        }
    }
}
