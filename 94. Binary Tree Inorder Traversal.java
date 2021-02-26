/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Author: KKDJoseph
 * Method: 没啥好说的，中根遍历，左根右
 * 第二种iteration可能需要思考一下
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList();
        helper(root, answer);
        return answer;
    }

    public void helper(TreeNode root, List<Integer> answer){
        if(root == null) return;
        helper(root.left, answer);
        answer.add(root.val);
        helper(root.right, answer);
    }
}

/**
 * Method: 向左走走到头，中间的节点用stack存，因为你要倒着往上走，而root.right就作为新的根节点还要经过整个过程
 * 要注意的是除了root！=null这个条件，还有stack不为空的条件，因为root为空的时候stack还会剩余他的父亲节点没访问
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> answer = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            answer.add(root.val);
            root = root.right;
        }
        return answer;
    }
}