package editor.cn;
// 757
// 设置交集大小至少为2

//一个整数区间 [a, b] ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。 
//
// 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。 
//
// 输出这个最小集合S的大小。 
//
// 示例 1: 
//
// 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
//输出: 3
//解释:
//考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
//且这是S最小的情况，故我们输出3。
// 
//
// 示例 2: 
//
// 输入: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
//输出: 5
//解释:
//最小的集合S = {1, 2, 3, 4, 5}.
// 
//
// 注意: 
//
// 
// intervals 的长度范围为[1, 3000]。 
// intervals[i] 长度为 2，分别代表左、右边界。 
// intervals[i][j] 的值是 [0, 10^8]范围内的整数。 
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        Solution s = new SetIntersectionSizeAtLeastTwo().new Solution();
        System.out.println(s.intersectionSizeTwo(new int[][]{}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] arr) {
            int n = arr.length;
            Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            List<Integer> ans = new ArrayList<>();
            ans.add(arr[n - 1][0]+1);
            ans.add(arr[n - 1][0]);
            for (int i = n - 2; i >= 0; i--) {
                int si = ans.size();
                if (ans.get(si-2) <= arr[i][1]) {

                } else if (ans.get(si-1) <= arr[i][1]) {
                    ans.add(arr[i][0]);
                } else {
                    ans.add(arr[i][0]+1);
                    ans.add(arr[i][0]);
                }
            }

            return ans.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
