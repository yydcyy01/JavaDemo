package com.yydcyy;

import org.junit.Test;

/**
 * Created by YYDCYY on 2019-05-19.
 *继承的好处：
 1，提高了代码的复用性。
 2，让类与类之间产生了关系，给第三个特征多态提供了前提.

 java中支持单继承。不直接支持多继承，但对C++中的多继承机制进行改良。
 单继承：一个子类只能有一个直接父类。
 多继承：一个子类可以有多个直接父类(java中不允许,进行改良)
 不直接支持，因为多个父类中有相同成员，会产生调用不确定性。

 在java中是通过"多实现"的方式来体现。

 java支持多层(多重,C继承B，B继承A)继承。会出现继承体系。

使用一个继承体系时，
 1，查看该体系中的顶层类，了解该体系的基本功能。
 2，创建体系中的最子类对象，完成功能的使用。

 继承所属关系： is a 关系。
 ********************************************
 *
 * 在子父类中，成员的特点体现。
 1，成员变量。
 2，成员函数。
 3，构造函数。

 当本类的成员和局部变量同名用this区分。
 当子父类中的成员变量同名用super区分父类。

 this和super的用法很相似。

 this:代表一个本类对象的引用。
 super：代表一个父类空间。

 *****************************
 * 当子父类中出现成员函数一模一样的情况，会运行子类的函数。
 这种现象，称为覆盖操作。这时函数在子父类中的特性。
 函数两个特性：
 1，overload重载。同一个类中。
 2，override覆盖也称为重写，覆写。。子类中。
 什么时候使用覆盖操作?

 当对一个类进行子类的扩展时，子类需要保留父类的功能声明，
 但是要定义子类中该功能的特有内容时，就使用覆盖操作完成.


 覆盖注意事项：
 1，子类方法覆盖父类方法时，子类权限必须要大于等于父类的权限。
 2，静态只能覆盖静态，或被静态覆盖。
****************************************************
 */
public class ExtendsDemo {
    @Test
    public void extendsDemo(){
        Student s = new Student();
        s.name= "zhangsan";
        s.age = 22;
        s.study();
    }
}


class Person2{
    String name;
    int age;
}



class Student extends/*继承*/ Person2
{
    //	String name;
//	int age;
    void study()
    {
        System.out.println(name+"...student study.."+age);
    }
}


class Worker extends Person2
{
    //	String name;
//	int age;
    void work()
    {
        System.out.println("worker work");
    }
}