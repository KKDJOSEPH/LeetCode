/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Author: KKDJoseph
 * Method: 判断树是不是balance的，类似5800讲的maxheap，是一颗almost balance的树，左右两边高度差不超过1
 * 和104差不多，反正你在计算当前深度的时候也要先算出左右两边的深度，所以就多进行一次比较就好了
 *
 * If recursive calls before conditional check, then its bottom up. If recursive call after conditional check, its top down.
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
    boolean answer = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return answer;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(right - left) > 1) answer = false;
        return Math.max(left, right) + 1;
    }
}