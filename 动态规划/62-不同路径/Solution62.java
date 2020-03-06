import java.util.Scanner;

/**
 * 解法一：动态规划（可画出数组更形象）
 *        例如 7 x 3的网格有如下变化：
 *             1 1 1        1 1 1
 *             1 1 1        1 2 3
 *             1 1 1        1 3 6
 *             1 1 1  ——>   1 4 10
 *             1 1 1        1 5 15
 *             1 1 1        1 6 21
 *             1 1 1        1 7 28
 *
 * 解法二：组合问题 C((m+n-2), (n-1))
 *
 */
public class Solution62 {
    private int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j ++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.print("输入m和n：");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println((new Solution62()).uniquePaths(m, n));
    }
}