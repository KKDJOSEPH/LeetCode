/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Author: KKDJoseph
 * Method: level order BFS/DFS
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList();
        if(root == null) return answer;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> cur = new ArrayList();
            int size = queue.size();
            while(size > 0){
                size--;
                TreeNode temp = queue.poll();
                cur.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            answer.add(new ArrayList<Integer>(cur));
        }
        return answer;
    }
}

/**
* DFS,用level做标志位，表明当前的node应该插入第几个list里面
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList();
        helper(answer, root, 0);
        return answer;
    }

    public void helper(List<List<Integer>> answer, TreeNode root, int level){
        if(root == null) return;
        if(answer.size() == level) answer.add(new ArrayList<Integer>());
        answer.get(level).add(root.val);
        helper(answer, root.left, level+1);
        helper(answer, root.right, level+1);
    }
}