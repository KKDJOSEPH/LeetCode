/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Author: KKDJoseph
 * Method: 取每一层的最后一个就行，还是level order
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
    // BFS做level order，取每一层的最后一个就好
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode temp = queue.poll();
                size--;
                if(size == 0) answer.add(temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
        }
        return answer;
    }
}