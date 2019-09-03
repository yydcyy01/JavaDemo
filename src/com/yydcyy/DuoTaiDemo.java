package com.yydcyy;

/**
 * Created by YYDCYY on 2019-05-25.
 *
 对象的多态性。
 猫 x = new 猫();
 动物 x = new 猫();//一个对象，两种形态。

 猫这类事物即具备者猫的形态，又具备着动物的形态。
 这就是对象的多态性。

 简单说：就是一个对象对应着不同类型.

 多态在代码中的体现：
 父类或者接口的引用指向其子类的对象。

 多态的好处：
 提高了代码的扩展性，前期定义的代码可以使用后期的内容。
 多态的弊端：
 前期定义的内容不能使用(调用)后期子类的特有内容。

 多态的前提：
 1，必须有关系，继承，实现。
 2，要有覆盖。

 */
public class DuoTaiDemo {

    public static void main(String[] args)
    {

//		Cat c = new Cat();
//		c.eat();
//		c.catchMouse();

        Animal a = new Cat(); //自动类型提升，猫对象提升了动物类型。但是特有功能无法s访问。
        //作用就是限制对特有功能的访问。
        //专业讲：向上转型。将子类型隐藏。就不用使用子类的特有方法。


//		a.eat();

        //如果还想用具体动物猫的特有功能。
        //你可以将该对象进行向下转型。
//		Cat c = (Cat)a;//向下转型的目的是为了使用子类中的特有方法。
//		c.eat();
//		c.catchMouse();

//		注意：对于转型，自始自终都是子类对象在做着类型的变化。
//		Animal a1 = new Dog();
//		Cat c1 = (Cat)a1;//ClassCastException


		/*
		Cat c = new Cat();

//		Dog d = new Dog();

//		c.eat();
		method(c);
//		method(d);
//		method(new Pig());
		*/

        method(new  Dog());



//		毕老师 x = new 毕老师();
//		x.讲课();
//		x.看电影();

        毕姥爷 x = new 毕老师();
        x.讲课();
        x.钓鱼();

        毕老师 y = (毕老师)x;//ClassCastException
        y.看电影();
    }

    public static void method(Animal a)//Animal a = new Dog();
    {
        a.eat();
        if (a instanceof Cat)//instanceof：用于判断对象的具体类型。只能用于引用数据类型判断	        //通常在向下转型前用于健壮性的判断。
        {
            Cat c = (Cat) a;
            c.catchMouse();
        } else if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.lookHome();
        } else {
        }


        Fu1.method();
        Zi1.method();
        Fu1 f = new Zi1();//
//		f.method();
//		f.show();
//		System.out.println(f.num);

//		Zi z = new Zi();
//		System.out.println(z.num);
    }
}

abstract class Animal {
    abstract void eat();
}

class Dog extends Animal {
    void eat() {
        System.out.println("啃骨头");
    }

    void lookHome() {
        System.out.println("看家");
    }
}

class Cat extends Animal {
    void eat() {
        System.out.println("吃鱼");
    }

    void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class Pig extends Animal {
    void eat() {
        System.out.println("饲料");
    }

    void gongDi() {
        System.out.println("拱地");
    }
}

//**********************************************8

/*
毕老师和毕姥爷的故事。
*/

class 毕姥爷
{
    void 讲课()
    {
        System.out.println("管理");
    }
    void 钓鱼()
    {
        System.out.println("钓鱼");
    }
}

class 毕老师 extends 毕姥爷
{
    void 讲课()
    {
        System.out.println("Java");
    }
    void 看电影()
    {
        System.out.println("看电影");
    }
}

//************************

/*
多态时，
成员的特点：
1，成员变量。
	编译时：参考引用型变量所属的类中的是否有调用的成员变量，有，编译通过，没有，编译失败。
	运行时：参考引用型变量所属的类中的是否有调用的成员变量，并运行该所属类中的成员变量。
	简单说：编译和运行都参考等号的左边。哦了。
	作为了解。



2，成员函数(非静态)。
	编译时：参考引用型变量所属的类中的是否有调用的函数。有，编译通过，没有，编译失败。
	运行时：参考的是对象所属的类中是否有调用的函数。
	简单说：编译看左边，运行看右边。

	因为成员函数存在覆盖特性。




3，静态函数。
		编译时：参考引用型变量所属的类中的是否有调用的静态方法。
		运行时：参考引用型变量所属的类中的是否有调用的静态方法。
		简单说，编译和运行都看左边。

		其实对于静态方法，是不需要对象的。直接用类名调用即可。




*/

class Fu1
{
    //	int num = 3;
    void show()
    {
        System.out.println("fu show");
    }

    static void method()
    {
        System.out.println("fu static method");
    }
}

class Zi1 extends Fu1
{
    //	int num = 4;
    void show()
    {
        System.out.println("zi show");
    }

    static void method()
    {
        System.out.println("zi static method");
    }
}
