package com.yydcyy;

import java.util.Scanner;

/**
 * Created by YYDCYY on 2019-05-22.
 */
public class scanfDemo {

        /**
         * @param args
         */
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner scanner = new Scanner(System.in);
            String input;
            System.out.println("输入一个整数a:");
            input = scanner.next();
            int a = Integer.parseInt(input);

            System.out.println("输入一个字符串b:");
            input = scanner.next();
            String b = input;

            System.out.println("输入一个浮点数c:");
            input = scanner.next();
            float c = Float.parseFloat(input);

            System.out.print("\n");
            System.out.printf("a=%d,类型是 %s\n", a, getType(a));
            System.out.printf("b=%s,类型是 %s\n", b, getType(b));
            System.out.printf("c=%f,类型是 %s\n", c, getType(c));


        }
    static String getType(Object o){
        return o.getClass().toString();
    }
}
