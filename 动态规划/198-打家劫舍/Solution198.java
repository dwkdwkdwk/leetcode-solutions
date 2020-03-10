import java.util.Arrays;

/**
 * 状态转移
 *
 * 注意本题中对状态的定义：
 * 考虑偷取 [x...n-1] 范围里的房子（函数的定义）
 * 根据对状态的定义，决定状态的转移：
 * f(0) = max{v(0) + f(2), v(1) + f(3), v(2) + f(4), ..., v(n-3) + f(n-1), v(n-2), v(n-1)} (状态转移方程)
 *
 */
public class Solution198 {

    /**
     * memo[i] 表示考虑抢劫 nums[i...n] 所能获得的最大收益
     */
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length){
            return 0;
        }
        // 记忆化搜索
        if (memo[index] != -1){
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[75];
        for (int i = 0; i < 75; i++) {
            nums[i] = i;
        }
        System.out.println((new Solution198().rob(nums)));
    }
}
