package com.yydcyy;

import org.junit.*;

/**
 * Created by YYDCYY on 2019-6-5
 * StringBufferDemo
 * **************************
 * StringBuilderDemo
 * **************************
 * /*
 * StringBuffer:就是字符串缓冲区。
 * 用于存储数据的容器。
 * 特点：
 * 1，长度的可变的。
 * 2，可以存储不同类型数据。
 * 3，最终要转成字符串进行使用。
 * 4，可以对字符串进行修改。
 *
 *
 * 既然是一个容器对象。应该具备什么功能呢？
 * 1，添加：
 * 		StringBuffer append(data);
 * 		StringBuffer insert(index,data);
 * 2，删除：
 * 		StringBuffer delete(start,end):包含头，不包含尾。
 * 		StringBuffer deleteCharAt(int index):删除指定位置的元素
 * 3，查找：
 * 		char charAt(index);
 * 		int indexOf(string);
 * 		int lastIndexOf(string);
 * 4，修改：
 * 		StringBuffer replace(start,end,string);
 * 		void setCharAt(index,char);
 *
 * 增删改查  C(create)U(update)R(read)D(delete)
 * ***********************
 * /*
 * jdk1.5以后出现了功能和StringBuffer一模一样的对象。就是StringBuilder
 *
 * 不同的是：
 * StringBuffer是线程同步的。通常用于多线程。
 * StringBuilder是线程不同步的。通常用于单线程。 它的出现提高效率。
 *
 * jdk升级：
 * 1，简化书写。
 * 2，提高效率。
 * 3，增加安全性。
 * class StringBuffer jdk1.0
 {
 object lock;
 public   StirngBuffer append(int x)
 { synchronized(lock)
 { } }


 public synchronized StringBuffer delete(int start,int end)
 { synchronized(lock) { } }}
 */

public class StringBuffer_BuilderDemo {
    @org.junit.Test
   public void run(){
        StringBuffer sb = new StringBuffer("abce");
        //System.out.println(sb.toString());
        sb.append("xixi");
        sb.insert(2, "qq");

        StringBuffer st = new StringBuffer();
        st.append(4).append(false);
        st.insert(1,"hahaha");
        st.append(true);

        //查找
        System.out.println(st.charAt(4));
        System.out.println(st.indexOf("haha3")); // -1 为没有找到, 其他为角标位置
        System.out.println(st.toString());

       //修改
        st.replace(0,3,"01234567"); // 删除指定位置的元素,然后str插入.
        //与String 区别: 修改后就修改了, String只是临时的
        st.setCharAt(1,'w');
        //删除
        st.delete(0,3);
        //st.delete(0,st.length()); // 直接清空缓冲区

        st.deleteCharAt(0);
        System.out.println(st.toString());
        st.setCharAt(1,' ');
        // 不可以为empty'' , 可以为' '; 所以和 delete不同
        System.out.println();
        System.out.println(st.toString());
        st.setLength(2);
        /*4 67hahafalsetrue
        4  只有两个了 */
        System.out.println(st.toString());

//****************************开始 StringBuilder JDK1.5后,的表演 那个线程不安全的

    }
    public static String arrayToString_2(int[] arr){

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1)
                sb1.append(arr[i]+", ");
            else
                sb1.append(arr[i]+"]");
        }
        return sb1.toString();
    }

    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder("hello");
        StringBuilder s2 = new StringBuilder("java");

        show(s1,s2);

        System.out.println(s1+"......."+s2);
        //StringBuilder 是引用类型, 不需返回值

    }

    private static void show(StringBuilder s1, StringBuilder s2) {

        s1.append(s2);
        s1 = s2;
    }
}
