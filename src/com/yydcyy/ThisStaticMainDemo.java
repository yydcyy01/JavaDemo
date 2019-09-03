package com.yydcyy;

import org.junit.Test;

/**
 * Created by YYDCYY on 2019-05-19.
 *
 * ***************************************
 * thisDemo
 * 1) This 学习

 2) 静态使用的注意事项：

3) 静态什么时候用？
     1，静态变量。
     2，静态函数。

 ***********************************************************
 /*
 public static void main(String[] args)

 主函数特殊之处：
 1，格式是固定的。
 2，被jvm所识别和调用。


 public:因为权限必须是最大的。
 static:不需要对象的,直接用主函数所属类名调用即可。
 void：主函数没有具体的返回值。
 main:函数名，不是关键字，只是一个jvm识别的固定的名字。
 String[] args:这是主函数的参数列表，是一个数组类型的参数，而且元素都是字符串类型。

 **************************************************************
 * //构造函数：构建创造对象时调用的函数。作用：可以给对象进行初始化。
 创建对象都必须要通过构造函数初始化。

 一个类中如果没有定义过构造函数，那么该类中会有一个默认的空参数构造函数。
 如果在类中定义了指定的构造函数，那么类中的默认构造函数就没有了。

 一般函数和构造函数什么区别呢？

 构造函数：对象创建时，就会调用与之对应的构造函数，对对象进行初始化。
 一般函数：对象创建后，需要函数功能时才调用。

 构造函数：对象创建时，会调用只调用一次。
 一般函数：对象创建后，可以被调用多次。


 什么时候定义构造函数呢？

 在描述事物时，该事物一存在就具备的一些内容，这些内容都定义在构造函数中。

 构造函数可以有多个，用于对不同的对象进行针对性的初始化.
 多个构造函数在类中是以重载的形式来体现的。


 细节：
 1，构造函数如果完成了set功能。set方法是否需要。
 2，一般函数不能直接调用构造函数。
 3，构造函数如果前面加了void就变成了一般函数。
 4，构造函数中是有return语句的。

 */

public class ThisStaticMainDemo {
    int num = 4;

 /* 当成员变量和局部变量重名，可以用关键字this来区分。

            this : 代表当前对象; this就是所在函数所属对象的引用。
    简单说：哪个对象调用了this所在的函数，this就代表哪个对象。

            this 也可以用于在构造函数中调用其他构造函数。
    注意：只能定义在构造函数的第一行。因为初始化动作要先执行。*/
    @Test
    public void thisDemo(){
        Person p1 = new Person("aa",30);//
        Person p2 = new Person("zz",30);

        System.out.println(p2.compare(p1));
//		new Person();
//		Person p = new Person("旺财",30);
//		p.speak();
//		Person p1 = new Person("小强");
//		p1.speak();
    }


    /*静态使用的注意事项：
            1，静态方法只能访问静态成员。(非静态既可以访问静态，又可以访问非静态)
            2，静态方法中不可以使用this或者super关键字。
            3，主函数是静态的。*/
        public static void main(String[] args) {

            new ThisStaticMainDemo().show();
        }
        public void show()
        {
            System.out.println(num);
        }
  /*  静态什么时候用？
            1，静态 变量。
    当被分析的对象中 所具备的成员变量的值都是相同的(共享数据),这个成员就可以被静态 static 修饰 。
    只要是特有数据，必须是非静态的,存储在对象中，。

            2，静态 函数。
    函数 是否用静态修饰，就参考一点，就是该函数功能是否有访问到对象中的特有数据。
    简单点说，从源代码看，该功能是否需要访问非静态的成员变量，如果需要，该功能就是非静态的。
    如果不需要，就可以将该功能定义成静态的。当然，也可以定义成非静态，
    但是非静态需要被对象调用，而仅创建对象调用非静态的
    没有访问特有数据的方法，该对象的创建是没有意义。*/

    @Test
    public void staticDemo2(){
        //		Demo d = new Demo(30);
        //		d.speak();
        Demo.speak();

        //		System.out.println("Hello World!");
    }


  /*  静态代码块。
    随着类的加载而执行。而且只执行一次。

    作用：
    用于给类进行初始化。*/
    @Test
    public void staticCodeDemo(){
        new StaticCode().show();
        new StaticCode().show();
        StaticCode.show();
    }



}
//This 说明类
class Person
{
    private String name;
    private int age;
    Person()
    {
        name = "baby";
        age = 1;
        System.out.println("person run");
    }
    Person(String name)
    {
        this();
        this.name = name;
    }
    Person(String name,int age)
    {
        this.name = name;
        this.age = age;
    }
    public void speak()
    {
        System.out.println(this.name+":"+this.age);
    }

    /*
    判断是否是同龄人。
    */
    public boolean compare(Person p)
    {
		/*
		if(this.age==p.age)
			return true;
		else
			return false;
		*/
        return this.age==p.age;
    }
}

/*
     Static Demo
    */
class Demo
{
    int age ;
    static int num = 9;
    Demo(int age)
    {
        this.age = age;
    }

    public static  void speak()
    {
        System.out.println(num);
    }
    public void show()
    {
        System.out.println(age);
    }

}
class StaticCode
{
    static int num ;
    static
    {
        num = 10;
        System.out.println("2333333333333. This is StaticCode Class static init result printf.");
    }
    StaticCode(){}

    static void show()
    {
        System.out.println("This is method show() , argument's num = " + num);
    }
}