package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-31.
 * String Demo
 * ***********************************8
 * /*
 * 1，给定一个字符串数组。按照字典顺序进行从小到大的排序。
 * {"nba","abc","cba","zz","qq","haha"}
 * 2，一个子串在整串中出现的次数。
 * "nbaernbatynbauinbaopnba"
 * 3，两个字符串中最大相同的子串。
 * 4，模拟一个trim功能一致的方法。
 */

public class StringDemo {


    public static void main(String[] args) {

        //将字节数组或者字符数组转成字符串可以通过String类的构造函数完成。
        char[] arr = {'w','a','p','q','x'};
        String s = new String(arr,1,3);
        System.out.println("s="+s);
//****************
        /* 演示字符串定义的第一种方式，并明确字符串常量池的特点.
        * 池中没有就建立，池中有，直接用。*/
        String s5 = "abc";
        String s6 = "abc";
        System.out.println("s5.equals(s6)" +s5.equals(s6));
        System.out.println("s5 == s6?  :"+ (s5 == s6));

        //***************************
      /*  String s2 = new String();//等效于String s = "";  不等效String s = null;
        byte[] arr1 = {97,66,67,68};
        String s1 = new String(arr1);
        System.out.println("s1="+s1);
        /*//**************************
        System.out.println("Demo3***************");
        String s3 = "abc";//创建一个字符串对象在常量池中。
        String s4 = new String("abc");//创建两个对象一个new一个字符串对象在堆内存中。
        //前者在常量池中, 后者在堆中
        System.out.println(s3==s4);//false

        System.out.println(s3.equals(s4));
        //string类中的equals复写Object中的equals建立了string类自己的判断字符串对象是否相同的依据。
        //其实就是比较字符串内容。

         ******************************
         *
         按照面向对象的思想对字符串进行功能分类。
         * "abcd"
         *
         * 1,获取：
         * 1.1 获取字符串中字符的个数(长度).
         * 		int length();
         * 1.2 根据位置获取字符。
         * 		char charAt(int index);
         * 1.3 根据字符获取在字符串中的第一次出现的位置.
         * 		int indexOf(int ch)
         * 		int indexOf(int ch,int fromIndex):从指定位置进行ch的查找第一次出现位置
         * 		int indexOf(String str);
         * 		int indexOf(String str,int fromIndex);
         * 		 根据字符串获取在字符串中的第一次出现的位置.
         * 		int lastIndexOf(int ch)
         * 		int lastIndexOf(int ch,int fromIndex):从指定位置进行ch的查找第一次出现位置
         * 		int lastIndexOf(String str);
         * 		int lastIndexOf(String str,int fromIndex);
         * 1.4 获取字符串中一部分字符串。也叫子串.
         * 		String substring(int beginIndex, int endIndex)//包含begin 不包含end 。
         * 		String substring(int beginIndex);
         *
         *
         *
         * 2，转换。
         * 		2.1 将字符串变成字符串数组(字符串的切割)
         * 			String[]  split(String regex):涉及到正则表达式.
         * 		2.2 将字符串变成字符数组。
         * 			char[] toCharArray();
         * 		2.3 将字符串变成字节数组。
         * 			byte[] getBytes();
         * 		2.4 将字符串中的字母转成大小写。
         * 			String toUpperCase():大写
         * 			String toLowerCase():小写
         *		2.5  将字符串中的内容进行替换
         *			String replace(char oldch,char newch);
         * 			String replace(String s1,String s2);
         * 		2.6 将字符串两端的空格去除。
         * 			String trim();
         * 		2.7 将字符串进行连接 。
         * 			String concat(string)
         * 3，判断
         * 		3.1 两个字符串内容是否相同啊？
         * 			boolean equals(Object obj);
         * 			boolean equalsIgnoreCase(string str);忽略大写比较字符串内容。
         * 		3.2 字符串中是否包含指定字符串？
         * 			boolean contains(string str);
         * 		3.3 字符串是否以指定字符串开头。是否以指定字符串结尾。
         * 			boolean startsWith(string);
         * 			boolean endsWith(string);
         *
         * 4，比较。
         */
//*************************
        System.out.println("demo3");
        String s1 = new String("abc");
        String s3 = "abc";
        String s2 = s1.intern();
        System.out.println(s1==s2);  // intern() 对字符串常量池进行操作, 证明new 对象在堆中, 不在常量池中
        s2 = s3;
        System.out.println(s2 == s3);
//*******************************************
        //1,获取：
        String s4 = "sadfljsaldkf4jsdjf";
        System.out.println(s4.length());
        System.out.println(s4.charAt(4));

        //System.out.println("s4.indexOf(4)  :  "+s4.indexOf(4)); //写法是错的, 返回 -1; 不可以索引 ,应该是传字符或字符串
        System.out.println("s4.indexOf(4)  :  "+s4.indexOf("4"));
        System.out.println(s4.indexOf("fj"));
        System.out.println(s4.indexOf("sdfsadfasdf", 4)); // -1表示没有
        System.out.println(s4.lastIndexOf('d')); // 字符d / 字符串 / 数字 最后一次出现位置
       // System.out.println(s4.lastIndexOf(4));  // -1 写法错误

        System.out.println("s4.substring(1,5)  :: "+s4.substring(1,5)); ////包含begin 不包含end
        System.out.println("s4.substring(4)" + s4.substring(4));

        //2，转换
        String s7 = "1,2,3,4,5,6,7,8  , 张东健 , 王凯";
        String[] t1 = s7.split(",");
        //String s7 = "1.2.3.4.5.6.7.8  . 张东健 . 王凯";
        //String[] t1 = s7.split("\\.");  // 正则表达式中, "." 是特殊字符, 需要进行转义
        for (String m : t1)
            System.out.print(m.trim() + " ");

        char[] ch = s7.toCharArray();
        for (char c : ch)
            System.out.print(c + "|");

        System.out.println();
        byte[] by = s7.getBytes();
        for (byte c : by)
            System.out.print(c + "|");

        System.out.println(s4.toUpperCase());
        System.out.println(s4.toLowerCase());

        System.out.println(s4.replace('j','J'));
        System.out.println(s4.replace("sadf", "YYDCYY"));

        System.out.println(s4.trim()); // 更改后不会改变原始数据, 若有需要情保存
        System.out.println(s4 + "  " + 1);
        System.out.println(s4.concat("  ").concat("1"));  //两个效果一样, + 比较常用, 方便

        //3，判断
        String s8 = "abcdef";
        String s9 = "abcdeF";
        String s10 = new String("abcdEf");
        System.out.println( s8 == s9);
        System.out.println(s8.equals(s10));
        System.out.println(s8.equalsIgnoreCase(s10));

        System.out.println(s10.contains("abc"));
        s10 = "www.yydcyy.com";
        System.out.println(s10.startsWith("www"));
        System.out.println(s10.endsWith("com"));

        // 4 比较
    }
}
