/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * Author: KKDJoseph
 * Method: 目标是把最后一层的结点求和，BFS分层每次都更新answer也可以，DFS每次进入判断level是否比之前的大，大就更新也行
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int answer = 0;
    int depth = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return answer;
    }

    public void helper(TreeNode root, int level){
        if(root == null) return; // 一定是要遍历完全节点的，如果在这设置depth > level就return，你另一侧的叶子就访问不到了
        if(depth <= level){
            if(depth < level) answer = 0;
            depth = level;
            answer += root.val;
        }
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}