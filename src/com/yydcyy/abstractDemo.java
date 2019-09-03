package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-21.
 * 抽象类 / 接口 /
 * 抽象类：
 抽象：笼统，模糊，看不懂！不具体。

 //继承弊端：打破了封装性。

 特点：
 1，方法只声明没有实现时，就是抽象方法，需要被abstract修饰。
 抽象方法必须定义在抽象类中。该类必须也被abstract修饰。

 2，抽象类不可以被实例化。为什么？因为调用抽象方法没意义。

 3，抽象类必须有其子类覆盖了所有的抽象方法后，该子类才可以实例化。
 否则，这个子类还是抽象类。


 1，抽象类中有构造函数吗？
 有，用于给子类对象进行初始化。



 2，抽象类可以不定义抽象方法吗？
 可以的。 但是很少见，目的就是不让该类创建对象。AWT的适配器对象就是这种类。
 通常这个类中的方法有方法体，但是却没有内容。

 *************************************
 * abstract class AbsDemo
 {
 abstract void show1();
 abstract void show2();
 }

 当一个抽象类中的方法都是抽象的时候，这时可以将该抽象类用
 另一种形式定义和表示，就是 接口 interface。


定义接口使用的关键字是interface,不是class

对于接口当中常见的成员：而且这些成员都有固定的修饰符。
1，全局常量: public  static final
2，抽象方法。public abstract
(默认, ,即使不写自动加  ==> 子类实现权限也应为Public
由此得出结论，接口中的成员都是公共的权限 (共享)

 接口与接口之间是继承关系，而且接口可以多继承

 *************************************************
 * 抽象类和接口的异同点：

 相同点：
 都是不断向上抽取而来的。

 不同点：
 1，抽象类需要被继承，而且只能单继承。
 接口需要被实现，而且可以多实现。
 2，抽象类中可以定义抽象方法和非抽象方法，子类继承后，可以直接使用非抽象方法。
 接口中只能定义抽象方法，必须由子类去实现。
 3，抽象类的继承，是is a关系，在定义该体系的基本共性内容。
 接口的实现是 like a 关系，在定义体系额外功能。

 *********************************

 */
public class abstractDemo {
    public void run1(){


    }

    /*
在java中不直接支持多继承，因为会出现调用的不确定性。
所以java将多继承机制进行改良，在java中变成了多实现。
一个类可以实现多个接口。
*/
    class Test implements A,Z//多实现
    {
        public int add(int a,int b)
        {
            return a+b+3;
        }
        /**/
        public void show(){}

    }
//    类 或 抽象类 在继承另一个类的同时，还可以实现多个接口
    abstract class Test2 extends DemoImpl implements A,Z
    {

    }
    class Test3 extends DemoImpl implements A,Z
    {

        @Override
        public void show() {

        }

        @Override
        public int add(int a, int b) {
            return 0;
        }
    }
}

interface Demo1{
    public static final int MUM = 3;

    public abstract void show1();
    public abstract void show2();
}

interface Demo2 extends Demo1{
    public static final int MUM = 4;
    public abstract void show3();
}

class DemoImpl implements/* 实现*/ Demo2{

    @Override
    public void show1() {
    }

    @Override
    public void show2() {
    }

    @Override
    public void show3() {
    }
}

interface A
{
    public void show();
}

interface Z
{
    public int add(int a,int b);
}

interface QQ extends  A,Z//接口与接口之间是继承关系，而且接口可以多继承。
{
    void function();
}

abstract class 犬
{
    abstract void 吼叫();
}

//abstract class 导盲
interface 导盲
{
    abstract void 导盲();
}

/* 3，抽象类的继承，是is a关系，在定义该体系的基本共性内容。
         接口的实现是 like a 关系，在定义体系额外功能。*/
class 导盲犬 extends 犬 implements 导盲
{
    public void 吼叫() //吃喝拉撒 ,通性
    {
    }
    public void 导盲(){}  // 特有技能 ,区分关键
}