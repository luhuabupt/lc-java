package editor.cn;
// 696
// 计数二进制子串

//给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。 
//
// 重复出现（不同位置）的子串也要统计它们出现的次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "00110011"
//输出：6
//解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
//注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
//另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。 
//
// 示例 2： 
//
// 
//输入：s = "10101"
//输出：4
//解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s[i] 为 '0' 或 '1' 
// 
// Related Topics 双指针 字符串 
// 👍 447 👎 0


public class CountBinarySubstrings {
    public static void main(String[] args) {
        Solution s = new CountBinarySubstrings().new Solution();
        System.out.println(s.countBinarySubstrings("0011"));
        System.out.println(s.countBinarySubstrings("11"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String ss) {
            int ans = 0;
            char[] s = ss.toCharArray();
            int n = s.length;
            int[] sum = new int[n];

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sum[i] = sum[i - 1];
                }
                sum[i] += s[i] - '0';
            }

            int pre = 0;
            for (int i = 1; i < n; i++) {
                if (s[i] == s[i - 1]) {
                    int x = sum[i];
                    if (i - (i - pre + 1) * 2 >= 0) {
                        x -= sum[i - (i - pre + 1) * 2];
                    }
                    if (i - (i - pre + 1) * 2 + 1 >= 0 && x == i - pre + 1) {
                        ans++;
                    }
                } else {
                    ans++;
                    pre = i;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
