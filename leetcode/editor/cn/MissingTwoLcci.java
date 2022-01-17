package editor.cn;

//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// Related Topics 位运算 数组 哈希表 
// 👍 48 👎 0


import java.util.Arrays;

public class MissingTwoLcci {
    public static void main(String[] args) {
        Solution s = new MissingTwoLcci().new Solution();
        System.out.println(Arrays.toString(s.missingTwo(new int[]{2,3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int n = nums.length + 2;

            int sum = 0;
            for (int v : nums) {
                sum += v;
            }
            sum = n * (n + 1) / 2 - sum;
            int avg = sum / 2;

            int ss = 0;
            for (int v : nums) {
                if (v <= avg) {
                    ss += v;
                }
            }

            int num = avg * (avg + 1) / 2 - ss;

            return new int[]{num, sum - num};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
