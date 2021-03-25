/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Author: KKDJoseph
 * Method: 排序后遍历
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

class Solution {
    // 排序后遍历即可，一样的数会挨着
    // 排序是nlogn
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int answer = nums[0];
        for(int i=1; i<nums.length; i++){
            if(answer == nums[i]) return answer;
            answer = nums[i];
        }
        return -1;
    }
}