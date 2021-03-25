/**
 * https://leetcode.com/problems/combination-sum/
 * Author: KKDJoseph
 * Method: 注意细节。可以反复使用，但不能重复用之前的数，所以需要start
 * 但下一次recursion也是从当前位置开始，这样就能重复用当前的数但不用之前的
 * 美硕给你的数组是排好序的，你可以先排序
 * 如果当前的和比target大就可以退了，如果排好序的数组就没必要往下试
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList();
        Arrays.sort(candidates);
        helper(answer, new ArrayList<Integer>(), candidates, target, 0, 0);
        return answer;
    }

    public void helper(List<List<Integer>> answer, List<Integer> cur, int[] nums, int target, int sum, int start){
        if(sum == target){
            answer.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(sum + nums[i] > target) return;
            cur.add(nums[i]);
            helper(answer, cur, nums, target, sum+nums[i], i);
            cur.remove(cur.size()-1);
        }
    }
}

