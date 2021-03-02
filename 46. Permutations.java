/**
 * https://leetcode.com/problems/permutations/
 * Author: KKDJoseph
 * Method: 排列，是A(n, k)，但是数字不能重复使用，所以需要标志位来做backtracking， 可以用set来做visitor， 但用boolean数组感觉更巧妙方便
 *
 * Time Complexity: A(n, k) = n!/(n-k)! A(5, 2) = 5*4 = 5!/(5-2)! O(n!)
 * Space Complexity: O(n!)
 */


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 还是要设置标志位来判断是否重复使用数字
        // 一开始想用set，但后来觉得用一个boolean数组更方便
        // 时间和空间复杂度应该是C(N, K), N!/(N-K)!, 近似为N!
        List<List<Integer>> answer = new ArrayList();
        helper(nums, answer, new ArrayList<Integer>(), new boolean[nums.length]);
        return answer;
    }

    public void helper(int[] nums, List<List<Integer>> answer, List<Integer> cur, boolean[] flag){
        if(cur.size() == nums.length){
            answer.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(flag[i]) continue;
            flag[i] = true;
            cur.add(nums[i]);
            helper(nums, answer, cur, flag);
            cur.remove(cur.size()-1);
            flag[i] = false;
        }
    }

}