package editor.cn;

//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 
// 👍 34 👎 0


public class FindClosestLcci {
    public static void main(String[] args) {
        Solution s = new FindClosestLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int i1 = -1000000, i2 = -1000000, ans = 1000001;
            for (int i = 0; i < words.length; i++ ) {
                String v = words[i];
                if (v.equals(word1)) {
                    i1 = i;
                    if (i1 - i2 < ans) {
                        ans = i1 - i2;
                    }
                }
                if (v.equals(word2)) {
                    i2 = i;
                    if (i2-i1 < ans) {
                        ans = i2-i1;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
