package com.yydcyy;

import org.junit.*;

import java.util.Arrays;

/**
 * Created by YYDCYY on 2019-06-05.
 * 自动装箱演示
 *
 * /*
 * 基本数据类型对象包装类。
 * 为了方便操作基本数据类型值，将其封装成了对象，在对象中定义了属性和行为丰富了该数据的操作。
 * 用于描述该对象的类就称为基本数据类型对象包装类。
 *
 * byte		Byte
 * short	Short
 * int		Integer
 * long		Long
 * float	Float
 * double	Double
 * char		Character
 * boolean	Boolean
 *
 * 该包装对象主要用基本类型和字符串之间的转换。
 *
 * 基本类型--->字符串
 * 		1,基本类型数值+""
 * 		2,用String类中的静态方法valueOf(基本类型数值);
 * 		3,用Integer的静态方法valueOf(基本类型数值);
 *
 * 字符串--->基本类型
 * 		1,使用包装类中的静态方法   xxx parseXxx("xxx类型的字符串");*****
 * 			int parseInt("intstring");
 * 			long parseLong("longstring");
 * 			boolean parseBoolean("booleanstring");
 * 			只有Character没有parse方法
 * 		2,如果字符串被Integer进行对象的封装。
 * 			可使用另一个非静态的方法，intValue();
 * 			将一个Integer对象转成基本数据类型值。

 */

public class WrapperDemo {
    private static final String SPACE_SEPARATOR = " ";

    @org.junit.Test
     public void run1(){
            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);

            int num = 4;
            Integer i  = new Integer(5);

            int x = Integer.parseInt("123");
            System.out.println(Integer.parseInt("123" ) + 1); // 124

            Integer t = new Integer("123");
            System.out.println(t.intValue()); //两个有啥区别
            System.out.println(t);

            //		十进制-->其他进制
            System.out.println(Integer.toBinaryString(60));
            System.out.println(Integer.toOctalString(60));
            System.out.println(Integer.toHexString(60));

            System.out.println(Integer.toString(60,15));

            //其他进制 -- > 十进制
            System.out.println(Integer.parseInt("40", 15));

            Integer a = new Integer("89");
            //Integer a = new Integer(89); 有啥区别
            Integer b = new Integer(89);
            System.out.println(a == b); // false
            System.out.println(a.equals(b)); //ture
            System.out.println(a.compareTo(b));  // 0,相等  源码按 == 比较

            //以上结果说明
            int num1 = 4;
            num1 = num1 + 5; //对比下面

            //Integer i =  4;//i = new Integer(4);自动装箱  简化书写。
            //i = i + 6;// i = new Integer(i.intValue() + 6); //i.intValue() 自动拆箱

            /*Integer z = 129; //false
            Integer y = 129;*/ //true

            Integer z = 127; //true
            Integer y = 127;
            System.out.println(z == y);
            System.out.println(z.equals(y));
//**************************************
            /*
             * 对一个字符串中的数值进行从小到大的排序。
             *
             * "20 78 9 -7 88 36 29"
             * 思路：
             * 1，排序，我很熟。可是我只熟int。
             * 2，如何获取到这个字符串中的这些需要排序的数值？
             * 发现这个字符串中其实都是空格来对数值进行分隔的。
             * 所以就想到用字符串对象的切割方法将大串变成多个小串。
             * 3，数值最终变成小字符串，怎么变成一个int数呢？
             * 字符串-->基本类型 可以使用包装类。
             */
            String numStr = "20 78 9 -7 88 36 29";
            System.out.println(numStr);
            numStr = sortStringNumber(numStr);
            System.out.println(numStr);
     }
    public static String arrayToString(int[] num_arr) {

        StringBuilder sb = new StringBuilder();
        for(int x = 0; x<num_arr.length; x++){
            if(x!=num_arr.length-1)
                sb.append(num_arr[x]+SPACE_SEPARATOR);
            else
                sb.append(num_arr[x]);
        }

        return sb.toString();
    }

    public static void mySortArray(int[] num_arr) {

        Arrays.sort(num_arr);
    }

    public static int[] toIntArray(String[] str_arr) {

        int[] arr = new int[str_arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str_arr[i]);
        }

        return arr;
    }
    public static String sortStringNumber(String numStr) {

        //1,将字符串变成字符串数组。
        String[] str_arr = stringToArray(numStr);

        //2,将字符串数组变成int数组。

        int[] num_arr = toIntArray(str_arr);

        //3,对int数组排序。
        mySortArray(num_arr);

        //4,将排序后的int数组变成字符串。

        String temp = arrayToString(num_arr);

        return temp;
    }
    /**
     * @param numStr
     */
    public static String[] stringToArray(String numStr) {
        String[] str_arr = numStr.split(SPACE_SEPARATOR);


        return str_arr;
    }
}
