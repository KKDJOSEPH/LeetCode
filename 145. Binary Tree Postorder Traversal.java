/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Author: KKDJoseph
 * Method: 左右根
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList();
        helper(root, answer);
        return answer;
    }

    public void helper(TreeNode root, List<Integer> answer){
        if(root == null) return;
        helper(root.left, answer);
        helper(root.right, answer);
        answer.add(root.val);
    }
}

/**
 * Method: 非常取巧，因为是左右根，根是最后一个访问的，无法像之前一样在访问左/右的时候把根带上，因为你在访问完左之后没法直接跳到右
 * 所以就对每个结点来说，都访问他的左孩子，有孩子，根节点，且是用stack储存，这样出栈顺序就是根， 右， 左
 * 且添加顺序是都在第0个位置添加，这也就使得answer内的顺序为
 * 根， 右根， 左右根
 */



class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> answer = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            answer.add(0, root.val);
            if(root.left != null) stack.add(root.left);
            if(root.right != null) stack.add(root.right);

        }
        return answer;
    }
}