package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-29.
 * Thread 演示实例
 *
 *
 /*
 线程安全问题产生的原因：
 1，多个线程在操作共享的数据。
 2，操作共享数据的线程代码有多条。

 当一个线程在执行操作共享数据的多条代码过程中，其他线程参与了运算。
 就会导致线程安全问题的产生。

 解决思路；
 就是将多条操作共享数据的线程代码封装起来，当有线程在执行这些代码的时候，
 其他线程时不可以参与运算的。
 必须要当前线程把这些代码都执行完毕后，其他线程才可以参与运算。

 在java中，用同步代码块就可以解决这个问题。

 同步代码块的格式：
 synchronized(对象)
 {
 需要被同步的代码 ；
 }
 同步的好处：解决了线程的安全问题。
 同步的弊端：相对降低了效率，因为同步外的线程的都会判断同步锁。
 同步的前提：同步中必须有多个线程并使用同一个锁。
************************************************
 同步函数的使用的锁是this；  //继承方法实现多线程

 同步函数和同步代码块的区别：
 同步函数的锁是固定的this。

 同步代码块的锁是任意的对象。

 建议使用同步代码块。

 */

public class ThreadDemo2 {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1 = new Thread(t); // 线程任务对象 多线程共享
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

       /* t1.start();
        t1.start();////一个线程不能开启两次，会抛出无效线程状态异常
        t1.start();
        t1.start();*/

    }
}

class Ticket implements Runnable{
    private int num = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized(obj){
                if (num > 0){
                    try{
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ".....sale...." + num --);
                }
            }
        }
    }
}