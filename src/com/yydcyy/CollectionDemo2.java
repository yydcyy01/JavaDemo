package com.yydcyy;

import org.junit.*;
import org.junit.Test;

import java.util.*;

/**
 * Created by YYDCYY on 2019-06-18.
 * 提醒: Person1 名字冲突, 加个1,  可能会在覆写contains所需的 hashCode(),  comparTo() 忘加打错, 忘了"person1"后的1而出错
 Comparator() Comparaable() 区别:
    自己写的方法,implements Comparator ;   class 覆写 compareTo() 的, implements Comparable
 * 视频 day17, day18
 * 1 : bean
 *
 * 2 : vector demo
 *
 * 3 : LinkedListDemo
 *
 * 4 : ArrayListDemo
 *
 * 5 : HashSetDemo
 *
 * 6 : comparatorDemo
 *
 * 7 : TreeSetDemo
 *
 * 8 : Map
 *    8.1 MapDemo  &&  Map 存与取出Map中元素 3 种方法
 *    8.2 HashMapDemo &&
 *   8.3 TreeMapDemo
 *********************************************************************
 * Map：一次添加一对元素。Collection 一次添加一个元素。
 Map也称为双列集合，Collection集合称为单列集合。
 其实map集合中存储的就是键值对。
 map集合中必须保证键的唯一性。


 常用方法：
 1，添加。
 value put(key,value):返回前一个和key关联的值，如果没有返回null.

 2，删除。
 void  clear():清空map集合。
 value remove(key):根据指定的key翻出这个键值对。

 3，判断。
 boolean containsKey(key):
 boolean containsValue(value):
 boolean isEmpty();

 4，获取。
 value get(key):通过键获取值，如果没有该键返回null。
 当然可以通过返回null，来判断是否包含指定键。
 int size(): 获取键值对的个数。



 Map常用的子类：
 |--Hashtable :内部结构是哈希表，是同步的。不允许null作为键，null作为值。
 |--Properties：用来存储键值对型的配置文件的信息，可以和IO技术相结合。
 |--HashMap : 内部结构是哈希表，不是同步的。允许null作为键，null作为值。
 |--TreeMap : 内部结构是二叉树，不是同步的。可以对Map集合中的键进行排序。
 **************************************************************************
 *
 *
 *
 *   13视频讲, 重点是Demo
 14视频, 重点是那个 LinkedList  实现队列和堆栈


 15 show(6) 赋值给引用类型, 才自动装箱 ; 基本数据类型和引用数据运算时候, 自动拆箱
 16 讲hashMap 感觉看过第3遍了,Demo实现就好了
 17 讲 hashMap 画图原理

 18 hashMap 确定是否相等, 画图原理
 19 HashSetTest hashcode(一般是*27 或 39, equals方法输出测试

 20 练习, 去重ArrayList:
 ArrayList, 判断元素重复与否, 用 equals;
 HashSet, 判断元素重复与否,contains 同时用 equals 和  hashCode
 数据结构不同, 判断元素重复与否不同, 源码见

 ArrayList de  remove方法, 删除是equals, 与地址无关

 21  LinkedHashSet

 22 TreeSet  有指定顺序, implements Comparable, 覆写comparTo() 方法, 比较, 返回-1/0/1

 add person 提示 ClassCastException , Comparable覆写, 比较出错

 Comparable 成为自然排序.  了的compareTo 方法称为自然比较方法(return -1/0/1)

 public class Person extends XXX implements Comparable {

 工厂中, 全小写, 编译器自动匹配
 compareTo() {类型强转, 都应该健壮性判断, }


 23  TreeSet 第二种比较方式
 写一个类, 比如
 public class ComparatorByName implements Comparator{
 //覆写compare
 public int compare (Object 1, Object 2){
 p1  = (Person)o1, p2 = ()o2;
 return p1.get... - p2.get ... ;

 }
 }   comparatoByName 作为参数传给TreeSet

 24 Demo TreeSet二叉树排序
 25 TreeSet 实现 sortByLength Demo
 *
 *
 *
 *
 Map关系图中, 虚线是接口
 Map 依次添加一对 <key, value> 可以镶嵌 eg key / value 可以继续是Map类型, 或 List, set等等称为单列集合, 双列集合
 Map 常用方法

 02 03
 说明:Collection 具有迭代器, Map 和Collection 没关系, 所以没有迭代器Iterator.
 不过可以拿所有 keySet()方法, 或者 values. 然后反过来获取value或 keys
 Map JavaAPI 说的"视图" , 是一种关系
 有一个关系图

 04
 <Map.Entry<K, V>>
 另一迭代方法 Set<Map.Entry<Integer, String>>  entry = map.entrySet();
 Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
 画了个内存图
 Map.Entry<> 就像class Outer{ // 内部接口,  可以点源码进去看
 // api中  描述map.Entry 说的是 嵌套内部类(封装形式, 为了对外使用, 将其暴露 ) 接口中的内部接口
 static class Inner{
 static void show(){}
 }
 }

 05  演示 values Demo

 06  api HashMap 允许 null;   HashTable null 不允许作为键值key/value
 回头看HashSet, api 说实现Set接口, 由HashMap实例提供支持

 HashTable 有个子类 -> properties  一般用于表示一个持久化信息, 常用

 07  Map存<Student , String>  覆写comparTo



 5，Map集合的特点以及常见子类的特点？

 6，Map集合中，取出所有元素原理，以及keySet,entrySet方法的使用，必须会？

 7，Map集合和Collection集合的区别？
 1，
 Map中一次存储是键值对。
 Collection中一次存储是单个元素。
 2，
 Map的存储使用的put方法。
 Collection存储使用的是add方法。
 3，
 Map的取出，是讲Map转成Set，在使用迭代器取出。
 Collection取出，使用就是迭代器。
 4，
 如果对象很多，必须使用容器存储。
 如果元素存在着映射关系，可以优先考虑使用Map存储或者用数组，
 如果没有映射关系，可以使用Collection存储。


 8，Map集合的使用场景。要求，将常见的体现之一：查表法回顾一下，并用map集合完成一次查表法。


 * */

public class CollectionDemo2 {
    /*1 : bean
     */

    /* 2 : vector demo    */
    @org.junit.Test
    public void VectorDemo() {
        Vector v = new Vector();
        //  System.out.println( v.addElement("abc1")); println(void ) 报错
             /*v.addElement("abc2");
             v.addElement("abc3");
             v.addElement("abc4");*/

        System.out.println(v.add("")); //true; 有返回值, 方法更通用
        v.add("abc2");
        v.add("abc3");
        v.add("abc4");

        Enumeration en = v.elements();
        while (en.hasMoreElements()) {
            System.out.println("nextelement : " + en.nextElement());
        }

        Iterator it = v.iterator();

        while (it.hasNext()) {
            System.out.println("next : " + it.next());
        }
    }

    /* 3 : LinkedListDemo */
    @Test
    public void LinkedListDemo() {
        LinkedList link = new LinkedList();

        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("abc4");
        //		System.out.println(link);
        //		System.out.println(link.getFirst());//获取第一个但不删除。
        //		System.out.println(link.getFirst());

        //		System.out.println(link.removeFirst());//获取元素但是会删除。
        //		System.out.println(link.removeFirst());
        System.out.println("peek :" + link.peek()); // 头
        System.out.println(link);
        Iterator it = link.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        while (!link.isEmpty()) {
            System.out.println(link.removeLast());
        }
    }

    /* 4 : ArrayListDemo
       * 定义功能去除ArrayList中的重复元素。
       *使用 contains,需要先覆写 equals 和 hashCode()方法
       * 自动比较时候, 你会发现 : java.lang.ClassCastException: 类型错误 (注:自己为了健壮性,定义的
       * 处理 :  compareTo()  覆写就好了(不是单纯比较数值大小, 故需要自己覆写比较方法
       *
       * 输出为 包.类名.hashCode() , 最好覆写 toString() 方法

        * */
    @Test
    public void ArrayListDemo() {
        ArrayList al = new ArrayList();
        al.add(new Person1("lisi1", 21));
        al.add(new Person1("lisi2", 22));
        al.add(new Person1("lisi3", 23));
        al.add(new Person1("lisi4", 24));
        al.add(new Person1("lisi2", 22));
        al.add(new Person1("lisi3", 23));
        System.out.println(al);
//[Person@22927a81, Person@78e03bb5, Person@5e8c92f4, Person@61e4705b, Person@50134894, Person@2957fcb0]

        al = getSingleElement(al);
        System.out.println(al.remove(new Person("lisi2", 22)));
        System.out.println(al);
    }

         /* 5 : HashSetDemo LinkedHashDemo
         内容同, 顺序不同, hashSet 有自己字典顺序, LinkedHashDemo 是Linked加入顺序
     */
         @Test
         public void HashSetDemo(){
//*************************** HashSet() 测试
           /*  HashSet hs = new HashSet();
             hs.add("hehe");
             hs.add("hahah");
             hs.add("aaa");
             hs.add("xixii");
             hs.add("hehe");*/
           /*  aaa
            hahah
            hehe
            xixii*/
//*************************** LinkedHashSet() 测试
            /* HashSet hs = new LinkedHashSet();
             hs.add("hehe");
             hs.add("hahah");
             hs.add("aaa");
             hs.add("xixii");
             hs.add("hehe");*/
             /*hehe
                hahah
                aaa
                xixii * */

           /*  Iterator it = hs.iterator();
             while(it.hasNext()){
                 System.out.println(it.next());
             }*/




		/*
		 * HashSet集合数据结构是哈希表，所以存储元素的时候，
		 * 使用的元素的hashCode方法来确定位置，如果地址相同(==)，在通过元素的equals来确定是否相同。
		 *
		 */
             HashSet hs = new HashSet();

             hs.add(new Person1("王奇",24));
             hs.add(new Person1("星期八",27));
             hs.add(new Person1("马户",21));
             hs.add(new Person1("王奇",29));
             hs.add(new Person1("星期八",27));
             Iterator it = hs.iterator();

             while(it.hasNext()){
                 Person1 p = (Person1)it.next();
                 System.out.println(p);

             }
         }



         /* 6 : comparatorDemo
            类在最后, 有实现

     */
    /* 7 : TreeSetDemo     */
    @Test
    public void TreeSetDemo(){
        //对字符串进行长度排序
        TreeSet ts = new TreeSet(new ComparatorByLength());

        ts.add("aaaaa");
        ts.add("zz");
        ts.add("nbaq");
        ts.add("cba");
        ts.add("abc");

        Iterator it = ts.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    /*
    *   8
    *   8.1 MapDemo  &&  Map 存与取出Map中元素 3 种方法
    *   8.2 HashMapDemo &&
    *   8.3 TreeMapDemo
    * */
    @Test
    public void MapDemo(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        method_2(map); // 取出Map中元素 3 种方法
    }
    static void method_2(Map<Integer,String> map){
    //只遍历所有 values
        map.put(8,"网络安全");
        map.put(2,"后端开发");
        map.put(7,"运维");
        map.put(6,"数据清洗");
        System.out.println("****** sout1 ****************");
        Collection<String> values = map.values();
        Iterator<String> it2 = values.iterator();
        while(it2.hasNext()){

            System.out.println(it2.next());
        }

		/*遍历 key , value
		 * 通过Map转成set就可以迭代, 找到了另一个方法。entrySet。
		 * 该方法将键和值的映射关系作为对象存储到了Set集合中，而这个映射关系的类型就是Map.Entry类型(结婚证)
		 */
        System.out.println("****** sout2 ****************");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();

        while(it.hasNext()){
            Map.Entry<Integer, String> me = it.next();
            Integer key = me.getKey();
            String value = me.getValue();
            System.out.println(key+"::::"+value);
        }

        //遍历 key , value
        //通过keySet方法获取map中所有的键所在的Set集合，在通过Set的迭代器获取到每一个键，
        //在对每一个键通过map集合的get方法获取其对应的值即可
        System.out.println("****** sout3 ****************");
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it3 = keySet.iterator();
        while(it3.hasNext()){
            Integer key = it3.next();
            String value = map.get(key);
            System.out.println(key+":"+value);
        }
    }

    //8.2 HashMapDemo
    @Test
    public void HashMapDemo(){
/*将学生对象和学生的归属地通过键与值存储到map集合中。*/
        HashMap<Person1,String> hm = new HashMap<Person1,String>();

        hm.put(new Person1("lisi",38),"北京");
        hm.put(new Person1("zhaoliu",24),"上海");
        hm.put(new Person1("xiaoqiang",31),"沈阳");
        hm.put(new Person1("wangcai",28),"大连");
        hm.put(new Person1("zhaoliu",24),"铁岭");

//		Set<Student> keySet = hm.keySet();
//		Iterator<Student> it = keySet.iterator();
        Iterator<Person1> it = hm.keySet().iterator();

        while(it.hasNext()){
            Person1 key = it.next();
            String value = hm.get(key);
            System.out.println(key.getName()+":"+key.getAge()+"---"+value);
        }
    }


        //TreeMapDemo  2019年6月21日
public void TreeMapDemo(){
    TreeMap<Person1,String> tm = new TreeMap<Person1,String>(new ComparatorByName());

    tm.put(new Person1("lisi",38),"北京");
    tm.put(new Person1("zhaoliu",24),"上海");
    tm.put(new Person1("xiaoqiang",31),"沈阳");
    tm.put(new Person1("wangcai",28),"大连");
    tm.put(new Person1("zhaoliu",24),"铁岭");


    Iterator<Map.Entry<Person1, String>> it = tm.entrySet().iterator();

    while(it.hasNext()){
        Map.Entry<Person1,String> me = it.next();
        Person1 key = me.getKey();
        String value = me.getValue();

        System.out.println(key.getName()+":"+key.getAge()+"---"+value);
    }
}











    /*
     * 定义功能去除ArrayList中的重复元素。
     * 另建了一个空间temp ,故有一个返回值,
      * 引用类型,一般可以直接修改al不需要返回
     */

    public static ArrayList getSingleElement(ArrayList al) {
        // 定义一个临时容器
        ArrayList temp = new ArrayList();
        // 迭代 al集合
        Iterator it = al.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // 判断temp中是否存在, 不存在则添加
            if (!temp.contains(obj))
                temp.add(obj);
        }
        return temp;
    }

}

/*1 : bean
覆写compareTo() 需要implements Comparable
     */
class Person1 implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person1(){
        super();
    }
    public Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 27;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof  Person1))
            throw new ClassCastException("类型错误");
            //classcast  小写不提示
        Person1 p = (Person1) obj; // 上面两个写法, 为了强转健壮性
        return this.name.equals(p.name) && this.age == p.age; //覆写 equals;
    }

    @Override
    public int compareTo(Object o) {
        Person1 p = (Person1) o;
        int temp = this.age - p.age;
        return temp == 0? this.name.compareTo(p.name) : temp; // 按年龄排序, 年龄相等再按姓名字典序排序
    }

    @Override
    public String toString() {
        return  "  name :: " + this.name + " ,age :: " + this.age;

    }
}

class ComparatorByLength implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        String s1 = (String)o1;
        String s2 = (String)o2;

        int temp = s1.length()-s2.length();

        return temp==0? s1.compareTo(s2): temp;
    }

}

/**
 * 创建了一个根据Person类的name进行排序的比较器。
 */
class ComparatorByName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Person1 p1 = (Person1)o1;
        Person1 p2 = (Person1)o2;

        int temp = p1.getName().compareTo(p2.getName());

        return temp==0?p1.getAge()-p2.getAge(): temp;
//		return 1;//有序。
    }
}