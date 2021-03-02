/**
 * https://leetcode.com/problems/symmetric-tree/submissions/
 * Author: KKDJoseph
 * Method: 比较树的左右是否对称，其实就是比较是否相同的变形，BFS解法需要注意一哈
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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}


//BFS 要注意一下，一个是add了两个root，再就是linkedlist里面可以存null，就正常存就好了，取出的时候比较是不是null就行
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size -= 2;
                TreeNode temp1 = queue.poll();
                TreeNode temp2 = queue.poll();
                if(temp1 == null && temp2 == null) continue;
                if(temp1 == null || temp2 == null) return false;
                if(temp1.val != temp2.val) return false;
                queue.add(temp1.left);
                queue.add(temp2.right);
                queue.add(temp1.right);
                queue.add(temp2.left);
            }
        }
        return true;
    }
}