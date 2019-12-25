package cn.yydcyy._3;

/**
 * @author YYDCYY
 * @create 2019-12-24
 *
 * // 搭配“标签 break”的 for 循环中使用 break 和 continue
 * continue inner; ( 后, i = 0; 恢复到当前状态)
 *
 */
public class _4LabeledFor {
    public static void main(String[] args) {
        int i = 0;

        outer: // 此处不允许存在执行语句

        for(; true ;) { // 无限循环

            inner: // 此处不允许存在执行语句

            for(; i < 10; i++) {
                System.out.println("i = " + i);
                if(i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if(i == 3) {
                    System.out.println("break");
                    i++; // 否则 i 永远无法获得自增
                    // 获得自增
                    break;
                }
                if(i == 7) {
                    System.out.println("continue outer");
                    i++;  // 否则 i 永远无法获得自增
                    // 获得自增
                    continue outer;
                }
                if(i == 8) {
                    System.out.println("break outer");
                    break outer;
                }
                for(int k = 0; k < 5; k++) {
                    if(k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                } /* for */
            } /* for */
        }/* for */
        // 在此处无法 break 或 continue 标签
        System.out.println("over...");
    }
}
