package editor.cn;
// 515
// 在每个树行中找最大值

//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,104] 
// -231 <= Node.val <= 231 - 1 
// 
//
//

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution s = new FindLargestValueInEachTreeRow().new Solution();
        System.out.println("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<Integer> ans;

        public List<Integer> largestValues(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);
            return ans;
        }

        public void dfs(TreeNode p, int d) {
            if (p == null) {
                return;
            }
            if (ans.size() <= d) {
                ans.add(p.val);
            } else {
                ans.set(d,  Math.max(ans.get(d), p.val));
            }
            dfs(p.left, d + 1);
            dfs(p.right, d + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
