package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-19.
 * 二维数组定义的格式 Demo
 */
public class Array2Demo {
    public static void main(String[] args) {
        int [] arr = new int[3]; //[I@1540e19d
        System.out.println(arr);

        int [][] arr1 = new int[3][2];
        System.out.println(arr1); //[[I@677327b6
        System.out.println(arr1[0]);  //[I@14ae5a5
        System.out.println(arr1[0][0]);  //0

        int[][] arr2 = new int[3][];
        System.out.println(arr2);  //[[I@7f31245a
        System.out.println(arr2[0]);  // null
        //System.out.println(arr2[0][0]);  //NullPointerException 没有初始化 ;  没有指明长度, jvm 无法自动初始化.

        int[][] arr3 = new int[3][2];
        System.out.println(arr3.length);  //3
        System.out.println(arr3[1].length);  //2

        {
            int sum = 0;
            int[][] arr4 = {{3, 1, 7}, {5, 8, 2, 9}, {4, 1}};

            for (int[] i : arr4)
                for (int j : i)
                    sum += j;

            System.out.println("sum=" + sum);
        }
    }
}
