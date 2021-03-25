/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Author: KKDJoseph
 * Method: 给定从左到右的array，要求输出成平衡二叉搜索树。
 * 要注意为了平衡高度，你每次插入必须是中间的点
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid+1, right);
        return root;
    }
}