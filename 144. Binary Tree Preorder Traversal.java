/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Author: KKDJoseph
 * Method: 根左右
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList();
        helper(root, answer);
        return answer;
    }

    public void helper(TreeNode root, List<Integer> answer){
        if(root == null) return;
        answer.add(root.val);
        helper(root.left, answer);
        helper(root.right, answer);
    }
}

/**
 * Method: 根左右，但是每个左孩子也都是根，所以answer要放在找左孩子的循环里，找完之后还是一样，要记录来的路径，用stack
 * 找到头之后再找右边，每个右孩子也是根，再走一遍就行
 */


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> answer = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                answer.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return answer;
    }
}