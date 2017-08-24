package com.htf.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 兼容参数为null的工具类
 * Created by PC-FENG on 2017/8/24.
 */
public class NullUtil {
    private NullUtil() {}

    public static <T> T nvl(T a, T b) {
        return a != null ? a : b;
    }

    public static int length(String str){
        return str==null?0:str.length();
    }

    public static boolean hasLength(String str){
        return str!=null && !str.isEmpty();
    }

    public static int size(Collection<?> c){
        return c==null?0:c.size();
    }

    public static boolean hasItem(Collection<?> c){
        return c!=null && !c.isEmpty();
    }

    public static boolean hasItem(Collection<?>... cs){
        return sumSize(cs)>0;
    }

    public static int sumSize(Collection<?>... cs){
        int total = 0;
        for(Collection<?> c : cs)
            if(c != null)
                total+=c.size();
        return total;
    }

    @SafeVarargs
    public static<T> Collection<T> addAll(Collection<T> newCollection, Collection<? extends T>... cs){
        for(Collection<? extends T> c : cs)
            if(c != null && !c.isEmpty())
                newCollection.addAll(c);
        return newCollection;
    }
    public static void main(String[] args) {
        List<Double> ld = new ArrayList<>();
        ld.add(5.54654D);
        List<Long> ll = new ArrayList<>();
        ll.add(65465464L);
        NullUtil.addAll(new ArrayList<Number>(), ld,ll);
    }
}
