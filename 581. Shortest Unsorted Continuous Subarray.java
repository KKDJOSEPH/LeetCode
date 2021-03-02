/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Author: KKDJoseph
 * Method: 目标是找到最短的连续未排序的子数组的长度，使得排序这段子数组后原数组就是升序排列
 * 一开始没什么思路，想到能不能排序原数组然后通过两数组比较来找到子数组起始和终止位置
 * 一开始还是想多了，想着可能数组分为多段，可能中间会有元素巧合的和排序后的位置重合
 * 但实际上你只需要找到开头和结尾，也就是最小的start和最大的end就好，不论中间是否有重合位置的元素
 * 他们都包含在了这个未排序的子数组内
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1) return 0;
        int start = nums.length, end = -1;
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] != temp[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end == -1 ? 0 : end-start+1;
    }
}