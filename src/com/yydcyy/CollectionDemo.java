package com.yydcyy;

import org.junit.*;

import java.util.*;

/**
 * Created by YYDCYY on 2019-06-06.
 * List 及其 Iterator , ListIterator Demo
 * java.util.ConcurrentModificationException  异常 是 迭代器 和 Collection  同时操作导致 (遍历和 add )
 *
 * 集合类的由来：
使用集合容器进行存储封装了的特有数据, 通常数据对象的个数不确定

 集合的一些技巧：

 需要唯一吗？
     需要：Set
         需要制定顺序：
             需要： TreeSet
             不需要：HashSet
            但是想要一个和存储一致的顺序(有序):LinkedHashSet
     不需要：List
         需要频繁增删吗？
             需要：LinkedList
             不需要：ArrayList

 如何记录每一个容器的结构和所属体系呢？

 看名字！


 List
 |--ArrayList
 |--LinkedList

 Set
 |--HashSet
 |--TreeSet

 后缀名就是该集合所属的体系。

 前缀名就是该集合的数据结构。

 看到array：就要想到数组，就要想到查询快，有角标.
 看到link：就要想到链表，就要想到增删快，就要想要 add get remove+frist last的方法
 看到hash:就要想到哈希表，就要想到唯一性，就要想到元素需要覆盖hashcode方法和equals方法。
 看到tree：就要想到二叉树，就要想要排序，就要想到两个接口Comparable，Comparator 。

 而且通常这些常用的集合容器都是不同步的。

 集合特点：
 1，用于存储对象的容器。
 2，集合的长度是可变的。
 3，集合中不可以存储基本数据类型值。

 集合容器因为内部的数据结构不同，有多种具体容器。不断的向上抽取，就形成了集合框架。

 框架的顶层Collection接口：
 Collection的常见方法：
 1，添加。
 boolean add(Object obj):
 boolean addAll(Collection coll):

 2，删除。
 boolean remove(object obj):
 boolean removeAll(Collection coll);
 void clear();

 3，判断：
 boolean contains(object obj):
 boolean containsAll(Colllection coll);
 boolean isEmpty():判断集合中是否有元素。

 4，获取：
 int size():
 Iterator iterator():取出元素的方式：迭代器。
 该对象必须依赖于具体容器，因为每一个容器的数据结构都不同,所以该迭代器对象是在容器中进行内部实现的。
 对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可，
 也就是iterator方法。

 Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
 其实就是抓娃娃游戏机中的夹子！

 5，其他：
 boolean retainAll(Collection coll);取交集。
 Object[] toArray():将集合转成数组。


 -------------------------------
 Collection
 |--List：有序(存入和取出的顺序一致),元素都有索引(角标)，元素可以重复。
 |--Set：元素不能重复,无序

 List:特有的常见方法：有一个共性特点就是都可以操作角标。

 1，添加
 void add(index,element);
 void add(index,collection);

 2，删除；
 Object remove(index):

 3，修改：
 Object set(index,element);

 4，获取：
 Object get(index);
 int indexOf(object);
 int lastIndexOf(object);
 List subList(from,to);

 list集合是可以完成对元素的增删改查。

 List:
 |--Vector:内部是数组数据结构，是同步的。增删，查询都很慢！
 |--ArrayList:内部是数组数据结构，是不同步的。替代了Vector。查询的速度快。
 |--LinkedList:内部是链表数据结构，是不同步的。增删元素的速度很快。

 作业：
 1，自己去查文档演示Vector中的elements()方法
 2，LinkedList中的，addFirst addLast getFirst，getLast  removeFirst removeLast。
 3，既然集合是存储对象的，请定义ArryaList集合，并存储Person对象。如new Person("lisi",20);
 并取出。将姓名和年龄打印出来。
 */
public class CollectionDemo {

    @org.junit.Test
    public void run() {
        /*Collection coll = new ArrayList();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");
//		System.out.println(coll);
        //使用了Collection中的iterator()方法。 调用集合中的迭代器方法，是为了获取集合中的迭代器对象。
//		Iterator it = coll.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
        for(Iterator it = coll.iterator(); it.hasNext(); ){
            System.out.println(it.next());
        }
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());
//		System.out.println(it.next());//java.util.NoSuchElementException
        /*//**********************

         show(coll);

         Collection c1 = new ArrayList();
         Collection c2 = new ArrayList();
         show(c1,c2);*/

        List list = new ArrayList();
        show(list);
    }

    public static void show(Collection c1, Collection c2) {
        //给c1添加元素。
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        //给c2添加元素。
        c2.add("abc1");
        c2.add("abc2");
        c2.add("abc3");
        c2.add("abc4");
        c2.add("abc5");
        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);
        //演示addAll
//		c1.addAll(c2);//将c2中的元素添加到c1中。
        //演示removeAll
//		boolean b = c1.removeAll(c2);//将两个集合中的相同元素从调用removeAll的集合中删除。
//		System.out.println("removeAll:"+b);

        //演示containsAll
//		boolean b = c1.containsAll(c2);
//		System.out.println("containsAll:"+b);

        //演示retainAll
        boolean b = c1.retainAll(c2);//取交集，保留和指定的集合相同的元素，而删除不同的元素。
        //和removeAll功能相反 。
        System.out.println("retainAll:" + b);
        System.out.println("c1:" + c1);
    }

    public static void show(Collection coll) {

        //1,添加元素。add.
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        System.out.println(coll);


        //2，删除元素。remove
        coll.remove("abc2");//会改变集合的长度 , 只删除第一个 "abc2"
        System.out.println(coll);

        //清空集合.
//		coll.clear();

        System.out.println("coll.contains\"abc3\" :: " + coll.contains("abc3"));
        System.out.println(coll);
    }

    public static void show(List list) {
        //添加元素
        list.add(":abc1");
        list.add(":abc2");
        list.add(":abc3");
        System.out.println(list);
        //插入元素。
//		list.add(1,"abc9");

        //删除元素。
//		System.out.println("remove:"+list.remove(2));

        //修改元素。
//		System.out.println("set:"+list.set(1, "abc8"));

        //获取元素。
//		System.out.println("get:"+list.get(0));

        //获取子列表。
        //System.out.println("sublist:"+list.subList(1, 2));//java.lang.IndexOutOfBoundsException: toIndex = 7  应先判断, 否则越界报错
        //System.out.println(list);
       /* Iterator it = list.iterator();

        }*/

        //list特有的取出元素的方式之一。
        for (int x = 0; x < list.size(); x ++){
            System.out.print("get : " + list.get(x));
        }


        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals(":abc2")) { //java.util.ConcurrentModificationException   java.util.ArrayList$Itr.checkForComodification
                //list.add("abc9"); //报错
                //it.add("abc9"); //加在 it下一个 (而不是末尾
                // 同时使用 也会报错 java.lang.IllegalStateException    at java.util.ArrayList$ListItr.set(ArrayList.java:941)
                it.set("abc9");
            }
            else
                System.out.print(obj);
        }
        System.out.println("list ::"+list);

        //倒着遍历
      while (it.hasPrevious()){
          System.out.print("previous : " + it.previous());
      }
        System.out.println("list : " + list);
    }
}