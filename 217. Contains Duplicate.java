/**
 * https://leetcode.com/problems/contains-duplicate/
 * Author: KKDJoseph
 * Method: ?
 *
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

class Solution {
    // nlogn排序然后遍历找有没有前后一样的数就好了
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}