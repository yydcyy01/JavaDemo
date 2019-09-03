package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-27.
 *
 * 进程：正在进行中的程序(直译).

 线程：就是进程中一个负责程序执行的控制单元(执行路径)
 一个进程中可以多执行路径，称之为多线程。
 一个进程中至少要有一个线程。

 开启多个线程是为了同时运行多部分代码。
 每一个线程都有自己运行的内容。这个内容可以称为线程要执行的任务。

 多线程好处：解决了多部分同时运行的问题。
 多线程的弊端：线程太多回到效率的降低。
 其实应用程序的执行都是cpu在做着快速的切换完成的。这个切换是随机的。


 JVM启动时就启动了多个线程，至少有两个线程可以分析的出来。

 1，执行main函数的线程，
 该线程的任务代码都定义在main函数中。

 2，负责垃圾回收的线程。
*********************************************
 * 如何创建一个线程呢？

 创建线程方式一：继承Thread类。

 步骤：
 1，定义一个类继承Thread类。
 2，覆盖Thread类中的run方法。
 3，创建(new)Thread的子类对象创建线程。
 4，调用start方法开启线程并调用线程的任务run方法执行。



 可以通过Thread的getName获取线程的名称 Thread-编号(从0开始)

 主线程的名字就是main。
 *
 *****************************************
 * XXXX.start(); 是开辟新 Thread , 多线程运行
 *
 * ******************************
 * Thread.currentThread().getName() / getxxxClassLoader() /  ....  好几个 神奇 学 jvm 看到的方法.
 * *****************************************
 * 多线程 中, 若某线程异常终止(包括 main  线程) , 其他线程继续进行,
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Demo3();
        new Demo3();
        new Demo3();
        System.gc();  // 调用垃圾回收
        System.out.println(" Hello World! ");
        /*
            Hello World!
            demo ok!
            demo ok!
            demo ok!  调用System.gc(), 没有终止啊 看看 API 如何说
        */
        //******************************
        /*创建线程的目的是为了开启一条执行路径，去运行指定的代码和其他代码实现同时运行。

        而运行的指定代码是所有执行路径的任务。

        jvm创建的主线程 Main 的任务都定义在了主函数中。

        自定义线程的任务在哪? run方法就是封装自定义线程运行任务的函数。
        开启线程是为了运行指定代码，所以只有继承Thread类，并复写run方法。
        将运行的代码定义在run方法中即可。*/
        Demo4 d1 = new Demo4("周星驰");
        Demo4 d2 = new Demo4("周润发");
        d1.start(); // 开启线程，调用run方法

        /*调用run和调用start有什么区别？
        * XXX.run();  是主线程 main 栈中顺序运行.
        * XXXX.start(); 是开辟新 Thread , 多线程运行
        * */
        d2.start();
        System.out.println("over...." + Thread.currentThread().getName());
}
}
class Demo3 extends Object{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("demo ok!");
    }
}

class Demo4 extends Thread{
    private String name;
    Demo4(String name){
        super(name);
        //this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i ++){
            System.out.println(name + ".....i = " + i + ".... name = "+ Thread.currentThread().getName());
        }
    }
}