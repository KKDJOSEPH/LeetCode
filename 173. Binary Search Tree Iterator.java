/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * Author: KKDJoseph
 * Method: 给一棵BST，做一些操作。其实BST的话inorder就解决一切
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
class BSTIterator {
    int index;
    List<Integer> answer;
    public BSTIterator(TreeNode root) {
        index = 0;
        answer = new ArrayList();
        helper(root, answer);
    }

    public void helper(TreeNode root, List<Integer> answer){
        if(root == null) return;
        helper(root.left, answer);
        answer.add(root.val);
        helper(root.right, answer);
    }

    public int next() {
        return answer.get(index++);
    }

    public boolean hasNext() {
        return index<answer.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */