package com.yydcyy;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by YYDCYY on 2019-06-22.
 * 泛型说明
 *
 GenericDemo1
 GenericDemo2 将泛型定义在接口上
 GenericDemo3 泛型通配符 ?
 GenericAdvanceDemo4 泛型通配符 上限extends ; 泛型通配符 下限super
 ? extends E:接收E类型或者E的子类型对象。上限！
 ? super E ：接收E类型或者E的父类型。下限！
********************************************
 * 泛型：
 jdk1.5出现的安全机制。

 好处：
 1，将运行时期的问题ClassCastException转到了编译时期。
 2，避免了强制转换的麻烦。

 <>:什么时候用？当操作的引用数据类型不确定的时候。就使用<>。将要操作的引用数据类型传入即可.
 其实<>就是一个用于接收具体引用数据类型的参数范围。

 在程序中，只要用到了带有<>的类或者接口，就要明确传入的具体引用数据类型 。

 泛型技术是给编译器使用的技术,用于编译时期。确保了类型的安全。

 运行时，会将泛型去掉，生成的class文件中是不带泛型的,这个称为泛型的擦除。
 为什么擦除呢？因为为了兼容运行的类加载器。

 泛型的补偿：在运行时，通过获取元素的类型进行转换动作。不用使用者在强制转换了。


 泛型的通配符：? 未知类型。

 泛型的限定：
 ? extends E: 接收E类型或者E的子类型对象。上限
 一般存储对象的时候用。比如 添加元素 addAll.

 ? super E: 接收E类型或者E的父类型对象。 下限。
 一般取出对象的时候用。比如比较器。
 ****************************************************************
 *
 *
重点 :
 1，泛型类，泛型方法，泛型接口什么时候用？并举例！
 2，泛型的通配符，以及泛型的限定的表现形式，和用法，以及什么时候用？
     ? extends E: 存储元素对象的时候用，你定义的是E类型，我们可以存储E类型或者E的子类型的对象。
     ? super E:从容器中取出元素时使用，容器中有E类型对象，取出时可使用E类型接收，或者E的父类型接收。比如比较器。
 3，泛型的细节作为了解？
 4，要求api中涉及泛型限定的方法一定要看的懂并会用，比如TreeSet集合的构造函数。
 */
public class GenericDemo {
    @org.junit.Test
    public void GenericDemo1(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("abc");//public boolean add(Object obj)
        Iterator<String> it = al.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        TreeSet<Person1> ts = new TreeSet<Person1>(new ComparatorByName());
        ts.add(new Person1("lisi8",21));
        ts.add(new Person1("lisi3",23));
        ts.add(new Person1("lisi",21));
        ts.add(new Person1("lis0",20));
        Iterator<Person1> it1 = ts.iterator();
        while(it1.hasNext()){
            Person1 p = it1.next();
            System.out.println(p.getName()+":"+p.getAge());
        }
    }

    //将泛型定义在接口上 class Tool<QQ> 77行代码
    @Test
    public void GenericDemo2(){
        /*
            class InterImpl implements Inter1<String>{
            class InterImpl2<Q> implements Inter1<Q>{
        */
        InterImpl in = new InterImpl();
        in.show("abc");

        InterImpl2<Integer> in2 = new InterImpl2<Integer>();
        in2.show(5);
    }
    ////在jdk1.5后，使用泛型来接收类中要操作的引用数据类型。
    //泛型类。什么时候用？当类中的操作的引用数据类型不确定的时候，就使用泛型来表示。

    // 为了做Demo4 , 泛型上下限, 注释了 Demo3.  需要就把demo4注释了, 3取消注释即可
 /*   @Test
    public void GenericDemo3(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("abc");
        al.add("hehe");

        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(5);
        al2.add(67);

        printCollection(al);
        printCollection(al2);
    }*/

    /**
     * 通配符 ? 迭代并打印集合中元素。
     * @param al
     */
   /* static void printCollection(Collection<?> al) {

        Iterator<?> it = al.iterator();
        while(it.hasNext()){
//			T str = it.next(); // T为类上 定义泛型类型
//			System.out.println(str);
            System.out.println(it.next().toString());
        }
    }*/

   /*
   * 可以对类型进行限定：
	 * ? extends E:接收E类型或者E的子类型对象。上限！
	 * ? super E ：接收E类型或者E的父类型。下限！
   * */

    /*static void printCollection(Collection<? extends Person1> al) {
        // extends 上限限定时,Iterator 直接用通用父类接口即可
            Iterator<? extends Person1> it = al.iterator();
            while(it.hasNext()){
//			T str = it.next(); // T为类上 定义泛型类型
//			System.out.println(str);
                Person1 p = it.next();
                System.out.println(p.getName() + ":: " + p.getAge());
            }
        }*/

    static void printCollection(Collection<? super Student1> al) {
        // extends 上限限定时,Iterator 直接用通用父类接口即可
        Iterator<? super Student1> it = al.iterator();
        while(it.hasNext()){
//			T str = it.next(); // T为类上 定义泛型类型
//			System.out.println(str);
            System.out.println(it.next().toString());
        }
    }
        //演示 泛型上下限
    @Test
    public void GenericAdvanceDemo4(){
        ArrayList<Person1> al = new ArrayList<Person1>();

        al.add(new Person1("abc",30));
        al.add(new Person1("abc4",34));

        ArrayList<Student1> al2 = new ArrayList<Student1>();

        al2.add(new Student1("stu1",11));
        al2.add(new Student1("stu2",22));
        ArrayList<String> al3 = new ArrayList<String>();

        al3.add("stu3331");
        al3.add("stu33332");

        printCollection(al);
        printCollection(al2);
        //printCollection(al3);//Collection<? extends Person1> al故不可以
        //Error:(109, 25) java: 不兼容的类型: java.util.ArrayList<java.lang.String>无法转换为java.util.Collection<? extends Person1>
    }


}

//泛型接口，将泛型定义在接口上。
interface Inter1<T>{
    public void show(T t);
}


class InterImpl2<Q> implements Inter1<Q>{

    public void show(Q q){
        System.out.println("show :"+q);
    }
}

class InterImpl implements Inter1<String>{
    public void show(String str){
        System.out.println("show :"+str);
    }
}

class Tool<QQ>{
    private QQ q;
    public QQ getObject(){
        return q;
    }

    public void setObject(QQ object){
        this.q = object;
    }

    //将泛型定义在方法上
    public <W> void show(W str){ //怎么调用?
        System.out.println("show :: " + str.toString());
    }

    public void print(QQ str){
        System.out.println("print :: " + str);
    }

   // 当方法静态时，不能访问类上定义的泛型。
    // 如果静态方法使用泛型, 只能将泛型定义在方法上
    public static <Y> void method (Y obj){
        System.out.println("method :: " + obj);
    }

}

class Student1 extends Person1{
    public Student1(String name, int age){
        super(name, age);
    }
}