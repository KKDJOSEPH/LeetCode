/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Author: KKDJoseph
 * Method: 目标是找到和target距离为K的所有结点，本质还是一个树内搜索问题，涉及到距离，就想到BFS
 * 但是问题在于你没法找你的父亲节点，所以先遍历一遍，用一个map保存每个节点的父亲节点，然后再BFS
 * 需要注意在访问时有重复访问的情况，因为每个节点被访问过后还会通过他的孩子再访问一次，所以要用一个set来储存visit过的点
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> answer = new ArrayList();
        Map<TreeNode, TreeNode> map = new HashMap();
        helper(root, root, map);
        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);
        Set<TreeNode> set = new HashSet();
        set.add(target);
        int counter = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                size--;
                TreeNode temp = queue.poll();
                if(counter == K) answer.add(temp.val);
                if(counter > K) return answer;
                if(temp.left != null && !set.contains(temp.left)){
                    queue.add(temp.left);
                    set.add(temp.left);
                }
                if(temp.right != null && !set.contains(temp.right)){
                    queue.add(temp.right);
                    set.add(temp.right);
                }
                if(!set.contains(map.get(temp))){
                    queue.add(map.get(temp));
                    set.add(map.get(temp));
                }
            }
            counter++;
        }
        return answer;
    }

    public void helper(TreeNode root, TreeNode father, Map<TreeNode, TreeNode> map){
        if(root == null) return;
        map.put(root, father);
        helper(root.left, root, map);
        helper(root.right, root, map);
    }
}