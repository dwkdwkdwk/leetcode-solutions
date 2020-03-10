import java.util.Scanner;

/**
 * 解法一：记忆化搜索
 */
public class Solution343 {
    private int[] memory;

    public int integerBreak(int n){
        memory = new int[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n){
        if (n == 2)
            return 1;
        if (memory[n] != 0)
            return memory[n];
        int res = -1;
        for (int i = 1; i <= n-1; i++) {
            res = max3(res,i*(n-i), i*breakInteger(n-i));
        }
        memory[n] = res;
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入正整数：");
        int n = scanner.nextInt();
        System.out.println((new Solution343()).integerBreak(n));
    }
}

/**
 * 解法二：动态规划
 */
/*

public class Solution343{

    private int integerBreak(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解dp[i],dp[i]表示将数字i分割成两部分的最大乘积
            for (int j = 1; j <= i-1; j++) {
                // j + (i - j)
                dp[i] = max3(dp[i], j * (i-j), j * dp[i-j]);
            }
        }
        return dp[n];
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入正整数：");
        int n = scanner.nextInt();
        System.out.print("最大乘积为：");
        System.out.println((new Solution()).integerBreak(n));
    }
}

*/
