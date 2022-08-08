package editor.cn;
// 522
// 最长特殊序列 II

//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。 
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。 
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。 
//
// 
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"
//、 "aeb" 和 "" (空字符串)。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: strs = ["aba","cdc","eae"]
//输出: 3
// 
//
// 示例 2: 
//
// 
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= strs.length <= 50 
// 1 <= strs[i].length <= 10 
// strs[i] 只包含小写英文字母 
// 
// Related Topics 数组 哈希表 双指针 字符串 排序 
// 👍 160 👎 0


import java.util.HashMap;
import java.util.Map;

public class LongestUncommonSubsequenceIi {
    public static void main(String[] args) {
        Solution s = new LongestUncommonSubsequenceIi().new Solution();
        System.out.println(s.findLUSlength(new String[]{"aaa", "aa", "aaa"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            Map<String, Boolean> m = new HashMap<>();
            for (String s : strs) {
                for (int i = 1; i < 1 << s.length(); i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < s.length(); j++) {
                        if (((1 << j) & i) > 0) {
                            sb.append(s.charAt(j));
                        }
                    }
                    String ss = sb.toString();
                    if (m.containsKey(ss) && m.get(ss)) {
                        m.put(ss, false);
                    }
                    m.putIfAbsent(ss, true);
                }
            }
            int ans = -1;
            for (String i : m.keySet()) {
                if (m.get(i) && i.length() > ans) {
                    ans = i.length();
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
