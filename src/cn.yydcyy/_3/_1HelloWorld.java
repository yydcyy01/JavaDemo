package cn.yydcyy._3;

/**
 * @author YYDCYY
 * @create 2019-12-24
 *
 * on Java8 第三章中的一个 Demo
 */
public class _1HelloWorld {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
