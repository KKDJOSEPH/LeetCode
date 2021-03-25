/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Author: KKDJoseph
 * Method: inorder traversal
 *
 * Time Complexity: O(N)
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
    // 注意index的问题，第k个是第k-1
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> answer = new ArrayList();
        helper(answer, root);
        return answer.get(k-1);
    }

    public void helper(List<Integer> answer, TreeNode root){
        if(root == null) return;
        helper(answer, root.left);
        answer.add(root.val);
        helper(answer, root.right);
    }
}