package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-26.
 *内部类访问特点：
 1，内部类可以直接访问外部类中的成员。
 2，外部类要访问内部类，必须建立内部类的对象。


 一把用于类的设计。

 分析事物时，发现该事物描述中还有事物，而且这个事物还在访问被描述事物的内容。
 这时就是还有的事物定义成内部类来描述。

 ******************************
 * 为什么内部类能直接访问外部类中成员呢？
 那是因为内部类持有了外部类的引用。  外部类名.this

 //***************************
 内部类可以存放在局部位置上。
 内部类在局部位置上只能访问局部中被final修饰的局部变量。
 ******************************
 * 匿名内部类。就是内部类的简写格式。其实就是一个匿名子类对象。
(匿名内部类在局部位置是, 访问的局部变量不需要被final修饰
 必须有前提： 内部类必须继承或者实现一个外部类或者接口。

 匿名内部类格式：new 父类or接口(){子类内容}
 ****************************************
 * Object obj = new Object()
 {
 public void show(){.... } };
 obj.show();//  提示报错, 因为匿名内部类被转换成Object类型, 不可以调用子类方法.

 */
public class InnerClassDemo {
    public static void main(String[] args) {
//        Outer out = new Outer();
//		out.method();
        //直接访问外部类中的内部类中的成员。
//		Outer.Inner in = new Outer().new Inner();  //这种方式用得少
//		in.show();

        //如果内部类是静态的。 相当于一个外部类
//		Outer.Inner in = new Outer.Inner(); // Inner为静态, 不需要new,直接调用
//		in.show();

        //如果内部类是静态的，成员是静态的。
		//Outer.Inner.function();

        //****************************
        new Outer2().method();

        //************* Outer3Demo
        Outer3 out = new Outer3();
        Object obj = out.method();
        System.out.println(obj);


        //****************
        new Outer4().method();

        //****************
        System.out.println("Outer 5");
        new Outer5().method();

        //*******************
        //InnerClassTest
        Outer1.method().show();
    }
}

class Outer
{
    private static int num = 31;

    /*static*/  class Inner// 内部类。
    {
        void show()
        {
            System.out.println("show run..."+num);
        }
		/*static*/ void function()//如果内部类中定义了静态成员，该内部类也必须是静态的。
		{
			System.out.println("function run ...."+num);
		}

    }

    public void method()
    {
        Inner in = new Inner();
        in.show();
    }
}


//************************************
//内部类直接访问外部类中成员情况
class Outer2
{
    int num = 3;
    class Inner
    {
        int num = 4;
        void show()
        {
            int num = 5;
            System.out.println(num); // 输出 5
            System.out.println(this.num);  //输出 4
            System.out.println(Outer2.this.num);  //输出 3
        }
    }
    void method()
    {
        new Inner().show();
    }
}


class Outer3
{
    int num = 3;
    Object method(){
        final int x = 9;
        //内部类可以存放在局部位置上。
        //此时只能访问局部中被final修饰的局部变量。
        class Inner{
            public String toString(){
                return "show ...." + x;
            }
        }
        Object in = new Inner();
        return in;
    }
}

class Outer4{
    int num = 4;
    public void method(){
        new Demol(){ //实现下面那个抽象接口
            void show(){
                System.out.println("show..." + num);
            }
        }.show();  // 没名字, 直接调用
    }
}

abstract class Demol{
    abstract void show();
}


class Outer5{
    void method(){
        Object obj = new Object(){  // 这是一个匿名内部类
            public void show(){
                System.out.println("show run");
            }
        };
        //obj.show();提示报错, 因为匿名内部类被转换成Object类型, 不可以调用子类方法.
    }
}



interface Inter{
    void show();
}
//**********************
class Outer1
{
    //补足代码 (建议用匿名内部类)
    static Inter method(){
        return new Inter(){  // 返回接口
            public void show(){
                System.out.println("implements's show()");
            };
        };  // 有个分号.
    }
}