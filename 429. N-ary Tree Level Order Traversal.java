/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * Author: KKDJoseph
 * Method: level-order traversal, BFS/DFS
 * I prefer DFS, faster and easier to write: you don't need the cur array, only need to add the root.val to corresponding
 * array
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// BFS
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> answer = new ArrayList();
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList();
            while(size > 0){
                size--;
                Node temp = queue.poll();
                cur.add(temp.val);
                for(Node i : temp.children) queue.add(i);
            }
            answer.add(new ArrayList<Integer>(cur));
        }
        return answer;
    }
}

// DFS
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList();
        helper(root, answer, 0);
        return answer;
    }

    public void helper(Node root, List<List<Integer>> answer, int level){
        if(root == null) return;
        if(answer.size() == level) answer.add(new ArrayList<Integer>());
        answer.get(level).add(root.val);
        for(Node i : root.children) helper(i, answer, level+1);
    }
}