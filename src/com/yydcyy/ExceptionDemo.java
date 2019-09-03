package com.yydcyy;

import org.junit.*;

/**
 * Created by YYDCYY on 2019-05-27.
 */
public class ExceptionDemo {
    /*
    * 异常：是在运行时期发生的不正常情况。。
在java中用类的形式对不正常情况进行了描述和封装对象,这些类被称为异常类
正常流程代码和异常处理代码分离。提高阅读性.
其实异常就是java通过面向对象的思想将问题封装成了对象.

不同的问题用不同的类进行具体的描述。 比如角标越界。空指针等等。
将其共性进行向上抽取，形成了异常体系。

异常就分成了两大类。
Throwable:无论是error，还是异常，问题，问题发生就应该可以抛出，让调用者知道并处理。
			//该体系的特点就在于Throwable及其所有的子类都具有可抛性。
			可抛性是通过两个关键字来体现的 : throws throw ,凡是可以被这两个关键字所操作的类和对象都具备可抛性.
	|--1，一般不可处理的。Error
			特点：是由jvm抛出的严重性的问题。
				 这种问题发生一般不针对性处理。直接修改程序
	|--2，可以处理的。Exception


该体系的特点： 子类的后缀名都是用其父类名作为后缀，阅读性很强。
********************************************************************
* 异常的分类：
1，编译时被检测异常:只要是Exception和其子类都是，除了特殊子类RuntimeException体系
		这种问题一旦出现，希望在编译时就进行检测，让这种问题有对应的处理方式。
		这样的问题都可以针对性的处理。

2，编译时不检测异常(运行时异常):RuntimeException和其子类( Exception 子类
		这种问题的发生，无法让功能继续，运算无法进行，更多是因为调用者的原因导致的而或者引发了内部状态的改变导致的。
		那么这种问题一般不处理，直接编译通过，在运行时，让调用者调用时的程序强制停止,让调用者对代码进行修正。

所以自定义异常时，要么继承Exception。要么继承RuntimeException。
throws 和throw的区别。

1，throws使用在函数上。
   throw使用在函数内。
2，throws抛出的是异常类，可以抛出多个，用逗号隔开。
   throw抛出的是异常对象。
   **************************************
   * 异常处理的原则：
1，函数内容如果抛出需要检测的异常，那么函数上必须要声明。
	否则必须在函数内用trycatch捕捉，否则编译失败。

2，如果调用到了声明异常的函数，要么trycatch要么throws，否则编译失败。

3，什么时候catch，什么时候throws 呢？
	功能内容可以解决，用catch。
	解决不了，用throws告诉调用者，由调用者解决 。

4，一个功能如果抛出了多个异常，那么调用时，必须有对应多个catch进行针对性的处理。
	内部又几个需要检测的异常，就抛几个异常，抛出几个，就catch几个。
try{}catch(){}catch(){}finally{}
****************************
* 子类覆盖父类只能抛出父类的异常或者子类或者子集。
注意：如果父类的方法没有抛出异常，那么子类覆盖时绝对不能抛，就只能try .
    */
    public static void main(String[] args) {
        //int [] n = new int[1024 * 1024 * 800]; //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }

    @org.junit.Test
    public void run1() throws FuShuIndexException {
        int[] arr = new int[3];

        ExceptionDemo d = new ExceptionDemo();
        //int num = d.method(null,-30);//java.lang.NullPointerException: 数组的引用不能为空！
        //int num = d.method(arr,-30);//java.lang.ArrayIndexOutOfBoundsException: 数组的角标不能为负数，哥们，你是真疯了！：-30
        //int num = d.method(arr,1);
       // System.out.println("num="+num);
        //System.out.println("over");

        try
        {
            int num = d.method(arr,-30);//java.lang.ArrayIndexOutOfBoundsException: 数组的角标不能为负数，哥们，你是真疯了！：-30
            //int num = d.method(arr,1);
            System.out.println("num="+num);
            System.out.println("over");
        }
        catch (FuShuIndexException e){
            System.out.println(e.toString());
        }
        finally{ //
            System.out.println("finally");
        }
        System.out.println("over!");
//*************************

    }

    public int method(int[] arr,int index) throws FuShuIndexException {

        if(arr==null)
            throw new NullPointerException("数组的引用不能为空！");

        if(index>=arr.length)
        {
            throw new ArrayIndexOutOfBoundsException("数组的角标越界啦，哥们，你是不是疯了？："+index);
        }
        if(index<0)
        {
            //throw new ArrayIndexOutOfBoundsException("数组的角标不能为负数，哥们，你是真疯了！："+index);
            throw new FuShuIndexException("角标变成负数啦！！");
        }
        return arr[index];
    }
}


/*
* 自定义异常类
* */

class FuShuIndexException extends Exception{
    FuShuIndexException(){
    }
    FuShuIndexException(String msg){
        super(msg);
    }
}

