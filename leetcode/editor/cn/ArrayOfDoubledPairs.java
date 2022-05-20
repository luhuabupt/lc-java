package editor.cn;
// 954
// 二倍数对数组

//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 104 
// arr.length 是偶数 
// -105 <= arr[i] <= 105 
// 
// Related Topics 贪心 数组 哈希表 排序 
// 👍 124 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution s = new ArrayOfDoubledPairs().new Solution();
        System.out.println(s.canReorderDoubled(new int[]{1, 3, 3, 6}));
        System.out.println(s.canReorderDoubled(new int[]{1,2,1,-8,8,-4,4,-4,2,-2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int v : arr) {
                cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            }
            Arrays.sort(arr);
            //System.out.println(Arrays.toString(arr));

            for (int v : arr) {
                if (cnt.get(v) == 0) {
                    continue;
                }
                int next = v > 0 ? v * 2 : v / 2;
                if (v < 0 && v % 2 != 0 || cnt.getOrDefault(next, 0) == 0) {
                    return false;
                }
                cnt.put(v, cnt.get(v) - 1);
                cnt.put(next, cnt.get(next) - 1);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
