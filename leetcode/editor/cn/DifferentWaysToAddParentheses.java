package editor.cn;
// 241
// 为运算表达式设计优先级

//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution s = new DifferentWaysToAddParentheses().new Solution();
        System.out.println(s.diffWaysToCompute("2*3-4*5"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> exp;
        List<Integer>[][] dp;

        public List<Integer> diffWaysToCompute(String expression) {
            for (int i = 0; i < expression.length(); i++) {
                char v = expression.charAt(i);
                if (v == '-' || v == '+' || v == '*') {
                    exp.add("" + v);
                }
            }
            int n = exp.length();
            dp = new List[n][n];
            dfs(0, n - 1);

            return dp[0][n - 1];
        }

        public void dfs(int l, int r) {
            if (dp[l][r] == null) {
                dp[l][r] = new ArrayList<>();
            }
            if (dp[l][r].size() > 0) {
                return;
            }
            if (r == l) {
                dp[l][r].add((int) exp.charAt(l) - '0');
            } else if (r - l == 2) {
                dp[l][r].add(cal(exp.charAt(l) - '0', exp.charAt(r) - '0', exp.charAt(l + 1)));
            } else {
                for (int i = l + 1; i < r; i += 2) {
                    dfs(l, i - 1);
                    dfs(i + 1, r);
                    for (int x : dp[l][i - 1]) {
                        for (int y : dp[i + 1][r]) {
                            dp[l][r].add(cal(x, y, exp.charAt(i)));
                        }
                    }
                }
            }
        }

        public int cal(int a, int b, char e) {
            if (e == '+') {
                return a + b;
            } else if (e == '-') {
                return a - b;
            }
            return a * b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
