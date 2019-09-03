package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-30.
 * 死锁演示Demo
 *
 * *****************
 * 多线程下的单例
 //双重判断模式,解决懒汉式 安全和效率问题.  不可以用同步函数(同步函数锁是this,单例函数是静态模式,只能用静态模块两个判断;)

 //所以写函数,恶汉式 比较简单.   面试才考双重判断懒汉式安全和效率问题
 静态函数中不可使用this,也不能使用get.Class();
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        // 演示死锁
        /*Test2 a = new Test2(true);
        Test2 b = new Test2(false);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();*/
        //***************************
        System.out.println("Hello  World ! ");
        //************************************
        System.out.println("****************");
        Ticke2 t = new Ticke2();
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t3.start();
        try{Thread.sleep(10);}catch(InterruptedException e){}
        t.flag = false;
        t4.start();
    }
}

class MyLock{
    public static final Object locka = new Object();
    public static final Object locab = new Object();
}

class Test2 implements Runnable{
    private boolean flag;
    Test2(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            while (true){
                synchronized(MyLock.locka){
                    System.out.println(Thread.currentThread().getName() + "..if   locka....");
                    synchronized(MyLock.locab){
                        System.out.println(Thread.currentThread().getName() + "..if   lockb....");
                    }
                }
            }
        }
        else {
            while (true){
                synchronized(MyLock.locab){
                    System.out.println(Thread.currentThread().getName() + "..else   lockb....");
                    synchronized(MyLock.locka){
                        System.out.println(Thread.currentThread().getName() + "..else   locka....");
                    }
                }
            }
        }
    }
}
//恶汉式  开发常用
class Single1{
    private static final Single1 s = new Single1();
    private Single1(){}
    public static Single1 getInstance(){
        return s;
    }
}

//懒汉式
/*
*  1 加入了同步为了解决多线程安全问题
*  2 加入了双重判断是为了解决效率问题
* */
class Single3{
    private static Single3 s = null; //没有 final
    private Single3(){}
    public static Single3 getInstance(){
        /*2*/if (s == null){
           /*1*/ synchronized(Single.class){  // static 静态函数中不可使用this,也不能使用get.Class();[非静态]
                /*0*/if (s == null) // 0 有线程安全问题  1 解决线程安全问题, 但是效率低. 2 解决效率问题.
                    s = new Single3();
            }
        }
        return s;
    }
}

//******************************************************************
class Ticke2 implements Runnable{
    private static int num = 100;
    //Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag){
            while (true){
                //synchronized(obj){
                synchronized(Ticket.class){ // this.getClass()
                    //show();
                    if (num > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            System.out.println(e.toString());
                        }
                        System.out.println(Thread.currentThread().getName() + ".....obj...." + num--);
                    }
                }
            }
        }
        else {
            while (true)
                this.show();
        }
    }

    public static synchronized void show(){

            if (num > 0){
                try{
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+".....function...."+num --);
                }
            }
    }
}
