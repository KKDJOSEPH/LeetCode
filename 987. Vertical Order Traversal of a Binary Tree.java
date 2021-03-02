/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Author: KKDJoseph
 * Method: 按垂直顺序排序，左孩子 x-1, y+1, 右孩子 x+1, y+1，要按y的顺序输出order
 * 所以我用了一个map按y保存每个list，list里面存pair，存每个节点和他的x值
 * 但为了知道最后的遍历起点和终点，需要找到minY和maxY， 并且对每个y对应的list都按x排序
 * 如果x相同，按val大小排序
 *
 * Time Complexity: 这个的好好分析一下
 * DFS O(n)， 排序: 正常有n个元素是nlog(n)，这假设说有k个list， 每个list里面存n/k个元素
 * 每个list 排序是 n/klog(n/k)
 * 一共k个list， O(nlog(n/k))
 * 一共 O(n + nlog(n/k)) = O(nlog(n/k))
 * Space Complexity: O(n) 一共store了N个element，就是N
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
    int min_Y = Integer.MAX_VALUE;
    int max_Y = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList();
        Map<Integer, List<Pair<Integer, TreeNode>>> map = new HashMap();
        helper(root, map, 0, 0);
        for(int i=min_Y; i<=max_Y; i++){
            List<Pair<Integer, TreeNode>> tempList = map.get(i);
            Collections.sort(tempList, (a, b)->{
                if(a.getKey() != b.getKey()) return a.getKey() - b.getKey();
                else return a.getValue().val - b.getValue().val;
            });
            List<Integer> cur = new ArrayList();
            for(Pair<Integer, TreeNode> p : tempList){
                cur.add(p.getValue().val);
            }
            answer.add(new ArrayList<Integer>(cur));
        }
        return answer;
    }

    public void helper(TreeNode root, Map<Integer, List<Pair<Integer, TreeNode>>> map, int x, int y){
        if(root == null) return;
        min_Y = Math.min(min_Y, y);
        max_Y = Math.max(max_Y, y);

        if(!map.containsKey(y)) map.put(y, new ArrayList<Pair<Integer, TreeNode>>());
        List<Pair<Integer, TreeNode>> temp = map.get(y);
        temp.add(new Pair(x, root));
        map.put(y, temp);
        helper(root.left, map, x+1, y-1);
        helper(root.right, map, x+1, y+1);
    }
}