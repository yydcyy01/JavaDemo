package cn.yydcyy._3;

/**
 * @author YYDCYY
 * @create 2019-12-25
 *  步骤: new过程 : 一层层递归调用( this() )构造函数, 至最后一层后, 开始初始化成员属性. 然后处理刚刚递归的构造函数. 最后至 new 处继续执行
 */
public class _8Flower {

        int petalCount = 0;
        String s = "initial value";

        _8Flower(int petals) {
            petalCount = petals;
            System.out.println("Constructor w/ int arg only, petalCount = " + petalCount);
        }

          _8Flower(String ss) {
            System.out.println("Constructor w/ string arg only, s = " + ss);
            s = ss;
        }

        _8Flower(String s, int petals) {
            this(petals);
            //- this(s); // Can't call two!
            this.s = s; // Another use of "this"
            System.out.println("String & int args");
        }

         _8Flower() {
            this("hi", 47);
            System.out.println("no-arg constructor");
        }

        void printPetalCount() {
            //- this(11); // Not inside constructor!
            System.out.println("petalCount = " + petalCount + " s = " + s);
        }

        public static void main(String[] args) {
            _8Flower x = new _8Flower();
            x.printPetalCount();
        }

}
