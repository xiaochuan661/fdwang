package com.mine.product.fdwang.util;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;


@SuppressWarnings({"unchecked","rawtypes"})
public class BinaryUtils {


    private static final Random RND = new Random();
    private static final SimpleDateFormat DF_DATE_NUM = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat DF_DATETIME_NUM = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Object DF_DATE_NUM_SYNC = new Object();
    private static final Object DF_DATETIME_NUM_SYNC = new Object();
    private static final Pattern IP_REGEX = Pattern.compile("[0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}[.][0-9]{1,3}");


    private static class RandomSortObject<E> {
        int id;
        E e;
        RandomSortObject(E e) {
            id = RND.nextInt();
            this.e = e;
        }
    }
    private static Comparator RandomSortComparator = new Comparator<RandomSortObject>() {
        @Override
        public int compare(RandomSortObject o1, RandomSortObject o2) {
            return o1.id>o2.id ? 1 : (o1.id==o2.id?0:-1);
        }
    };


    private BinaryUtils() {
    }


    /**
     * 是否是数组或java.util.List
     * @param c
     */
    public static boolean isArray(Class<?> c) {
        return c.isArray() || List.class.isAssignableFrom(c);
    }

    /**
     * 获取数组或List长度
     * @param array
     * @return
     */
    public static int getArrayLength(Object array) {
        return array==null ? 0 : (array instanceof List) ? ((List)array).size() : Array.getLength(array);
    }

    /**
     * 获取数组或List元素类型
     * @param array
     * @return 如果数组为空或数组每一个元素都为null, 则返回null
     */
    public static Class<?> getComponentType(Object array) {
        if(array == null) return null;
        int length = getArrayLength(array);
        Class<?> type = null;
        for(int i=0; i<length; i++) {
            Object v = getArrayValue(array, i);
            if(v != null) {
                type = v.getClass();
                break;
            }
        }
        return type;
    }

    /**
     * 获取数组元素
     * @param array
     * @param index
     * @return
     */
    public static Object getArrayValue(Object array, int index) {
        return array instanceof List ? ((List)array).get(index) : Array.get(array, index);
    }


    /**
     * 设置数组元素
     * @param array
     * @param index
     * @param value
     */
    public static void setArrayValue(Object array, int index, Object value) {
        if(array instanceof List) {
            List list = (List)array;
            if(list.size() < index) {
                throw new ArrayIndexOutOfBoundsException(index);
            }else if(list.size() == index) {
                list.add(value);
            }else {
                list.remove(index);
                list.add(index, value);
            }
        }else {
            Array.set(array, index, value);
        }
    }


    /**
     * 创建数组对象
     * @param componentType
     * @param length
     * @return
     */
    public static <T> T[] newArrayInstance(Class<T> componentType, int length) {
        return (T[])Array.newInstance(componentType, length);
    }




    public static boolean is(Boolean b) {
        return b!=null && b.booleanValue();
    }

    public static boolean isEmpty(Object v) {
        return isEmpty(v, true);
    }



    /**
     * 判断对象是否为空, 其中String、Collection、Map、Array会判断是否为空内容, 其他对象都为判断是否为null
     * @param v : 判断对象
     * @param trim : 如果判断对象类型为String类型时, 设置是否先trim()再判断
     * @return
     */
    public static boolean isEmpty(Object v, boolean trim) {
        if(v == null) return true;
        if(v instanceof String) {
            String sv = (String) v;
            return trim ? sv.trim().length()==0 : sv.length()==0;
        }else if(v instanceof Collection) {
            Collection<?> c = (Collection<?>)v;
            return c.size() == 0;
        }else if(v instanceof Map) {
            Map<?,?> m = (Map<?,?>)v;
            return m.size() == 0;
        }else if(isArray(v.getClass())) {
            return getArrayLength(v) == 0;
        }
        return false;
    }




    /**
     * 对List批量添加元素
     * @param master
     * @param array
     * @return
     */
    public static <T> List<T> addAsList(List<T> master, T[] array) {
        if(array == null) return master;
        if(master == null) master = new ArrayList<T>();
        for(int i=0; i<array.length; i++) {
            master.add(array[i]);
        }
        return master;
    }



    /**
     * 获取uuid
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }



    /**
     * 获取一个整数的位数, 如0=1位, 8=1位, 11=2位, 132=3位, 431346=6位
     * 效率比通过String.valueOf(v).length()快很多
     * @param v : 整数
     * @return 位数
     */
    public static int getBits(long v) {
        if(v < 0) v = 0 - v;

        int len = 1;
        while(v > 9) {
            v /= 10;
            len ++ ;
        }

        return len;
    }



    /**
     * 验证参数是否为空
     * @param value: 验证对象
     * @param name: 参数名称
     * @return
     */
    public static void checkNull(Object value, String name) {
        if(value == null) {
            throw new IllegalArgumentException(" the '"+name+"' is null argument! ");
        }
    }



    /**
     * 验证参数是否为空
     * @param value: 验证对象
     * @param name: 参数名称
     * @return
     */
    public static void checkEmpty(Object value, String name) {
        checkEmpty(value, true, name);
    }

    /**
     * 验证参数是否为空
     * @param value: 验证对象
     * @param trim: 如果值是String类型时是否time
     * @param name: 参数名称
     * @return
     */
    public static void checkEmpty(Object value, boolean trim, String name) {
        if(isEmpty(value, trim)) {
            throw new IllegalArgumentException(" the '"+name+"' is "+(value==null?"null":"empty")+" argument! ");
        }
    }




    /**
     * 将二进制数按单位转换
     * @param v
     * @return
     */
    public static String toByteUnit(Long v) {
        if(v == null) return null;

        if(v >= 1125899906842624l) {
            return ((double)((long)(((double)v*100)/1125899906842624l)))/100 + "P";
        }else if(v >= 1099511627776l) {
            return ((double)((long)(((double)v*100)/1099511627776l)))/100 + "T";
        }else if(v >= 1073741824) {
            return ((double)((long)(((double)v*100)/1073741824)))/100 + "G";
        }else if(v >= 1048576) {
            return ((double)((long)(((double)v*100)/1048576)))/100 + "M";
        }else if(v >= 1024) {
            return ((double)((long)(((double)v*100)/1024)))/100 + "K";
        }else {
            return v + "";
        }
    }






    /**
     * 获取日期格式数值, 格式为：yyyyMMdd
     * @return
     */
    public static int getNumberDate() {
        return getNumberDate(new Date());
    }
    public static int getNumberDate(Date date) {
        synchronized (DF_DATE_NUM_SYNC) {
            return Integer.parseInt(DF_DATE_NUM.format(date));
        }
    }




    /**
     * 获取日期时间格式数值, 格式为：yyyyMMddHHmmss
     * @return
     */
    public static long getNumberDateTime() {
        return getNumberDateTime(new Date());
    }
    public static long getNumberDateTime(Date date) {
        synchronized (DF_DATETIME_NUM_SYNC) {
            return Long.parseLong(DF_DATETIME_NUM.format(date));
        }
    }










    /**
     * 随机排序 (打乱队列的排列顺序)
     * @param array
     */
    public static <T> void randomSort(T[] array) {
        if(array==null || array.length<2) return ;
        RandomSortObject<T>[] ros = new RandomSortObject[array.length];
        for(int i=0; i<array.length; i++) {
            ros[i] = new RandomSortObject(array[i]);
        }
        Arrays.sort(ros, RandomSortComparator);

        for(int i=0; i<array.length; i++) {
            array[i] = ros[i].e;
        }
    }


    /**
     * 随机排序 (打乱队列的排列顺序)
     * @param list
     */
    public static <T> void randomSort(List<T> list) {
        if(list==null || list.size()<2) return ;

        RandomSortObject<T>[] ros = new RandomSortObject[list.size()];
        for(int i=0; i<ros.length; i++) {
            ros[i] = new RandomSortObject(list.get(i));
        }
        Arrays.sort(ros, RandomSortComparator);

        for(int i=0; i<ros.length; i++) {
            list.set(i, ros[i].e);
        }
    }






    private static String getIpDan(String ip) {
        int i = ip.indexOf('.');
        String d = i>0 ? ip.substring(0, ip.indexOf('.')) : ip;
        if(d.length() == 1) return "00"+d;
        if(d.length() == 2) return "0"+d;
        return d;
    }




}
