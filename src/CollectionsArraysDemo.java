/**
 * Created by YYDCYY on 2019-06-22.
 *
 *  * Collections：是集合框架的工具类。
 *      里面的方法都是静态的。
 */
public class CollectionsArraysDemo {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0;i < n; i ++) {
            res[i][0] = 1;
        }
            for (int i = 0; i < n;i ++) {
                res[0][i] = 1;
            }

            for (int i = 1; i < m; i ++) {
                for (int j = 1; j < n; j++)
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
            }

        return res[m - 1][n - 1];
    }
}
