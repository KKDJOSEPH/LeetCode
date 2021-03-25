/**
 * https://leetcode.com/problems/subsets/
 * Author: KKDJoseph
 * Method: subsets, 组合的子数组
 *
 * Time Complexity: O(N*2^n)
 * Space Complexity: O(n)
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 几个注意点 长度不一致，所以要循环长度
        // 不能用自己之前的元素，所以需要start
        // 每次进入recursion的循环中后，下一次的起始位置是当前位置+1， 不是恒定的start+1
        List<List<Integer>> answer = new ArrayList();
        for(int i=0; i<=nums.length; i++){
            helper(answer, new ArrayList<Integer>(), nums, i, 0);
        }
        return answer;
    }

    public void helper(List<List<Integer>> answer, List<Integer> cur, int[] nums, int length, int start){
        if(cur.size() == length){
            answer.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i=start; i<nums.length; i++){
            cur.add(nums[i]);
            helper(answer, cur, nums, length, i+1);
            cur.remove(cur.size()-1);
        }
    }
}