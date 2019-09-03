package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-18.
 * 实现 10进制转换 2 8 16进制.
 */
public class ArrayTest {

    public static void main(String[] args) {
        toBinary(16);
    }

    public static void toHex (int num){
        trans(num, 15, 4); //4位2进制 == 1位16进制
    }

    public static void toBinary (int num){
        trans(num, 1, 1); //4位2进制 == 1位16进制
    }
    public static void toOctal (int num){
        trans(num, 7, 3); //4位2进制 == 1位16进制
    }
    //进制转换通用函数
    public static void trans(int num, int base, int offset){
        //边界检查
        if (num == 0){
            System.out.println("0");
            return;
        }

        //定义一个对应关系表
        char [] chs = {'0' ,'1', '2','3',
                        '4', '5', '6', '7',
                        '8', '9', 'A', 'B',
                        'C', 'D', 'E', 'F'};

        //存结果, 最长32位.
        char[] arr = new char[32];
        int pos = arr.length - 1;

        int temp = 0;
        while ( num != 0){
            temp = num & base;  // 8进制 0~7  即 & 1111111
            arr[pos --] = chs[temp];
            num = num >>> offset;
        }

        for (int x = pos; x < arr.length; x ++){
            System.out.print(arr[x]);
        }
        System.out.println();
    }
}
