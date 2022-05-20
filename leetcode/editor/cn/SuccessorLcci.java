package editor.cn;
// 面试题 04.06
// 后继者

//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//

public class SuccessorLcci {
    public static void main(String[] args) {
        Solution s = new SuccessorLcci().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        Boolean flag = false;
        TreeNode ans;
        int find;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            find = p.val;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode p) {
            if (p == null) {
                return;
            }

            dfs(p.left);

            if (flag) {
                ans = p;
                flag = false;
                return;
            }
            if (p.val == find) {
                flag = true;
            }

            dfs(p.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
