/**
 * https://leetcode.com/problems/combinations/
 * Author: KKDJoseph
 * Method: combination，求组合，不能用本身，也不能用之前的数，用start标志当前位置
 * 且下一次recursion从i+1开始
 *
 * Time Complexity: O(k*C(n, k))
 * Space Complexity: O(C(n, k))
 */

class Solution {
    // 不能用之前的，所以用start标志位
    // 第一次for循环用来遍历开头，后面的递归回溯来填充
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList();
        helper(answer, new ArrayList<Integer>(), n, k, 1);
        return answer;
    }

    public void helper(List<List<Integer>> answer, List<Integer> cur, int n, int size, int start){
        if(cur.size() == size){
            answer.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=start; i<=n; i++){
            cur.add(i);
            helper(answer, cur, n, size, i+1);
            cur.remove(cur.size()-1);
        }
    }
}