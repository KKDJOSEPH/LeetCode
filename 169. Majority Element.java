/**
 * https://leetcode.com/problems/majority-element/solution/
 * Author: KKDJoseph
 * Method: DC
 *
 * Time Complexity: O(nlogn) T(n) = 2*T(n/2) + 2n
 * Space Complexity: O(N)
 */

class Solution {
    // 分治法
    // 分为两半，左边和右边majority相等么，不相等就回去查次数，看谁出现的多就是谁
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = left+(right-left)/2;
        int leftmax = helper(nums, left, mid);
        int rightmax = helper(nums, mid+1, right);
        if(leftmax == rightmax) return leftmax;
        int leftcount = helper2(nums, left, mid, leftmax);
        int rightcount = helper2(nums, mid+1, right, rightmax);
        return leftcount>rightcount ? leftmax : rightmax;
    }

    public int helper2(int[] nums, int left, int right, int target){
        int counter = 0;
        for(int i=left; i<=right; i++){
            if(nums[i] == target) counter++;
        }
        return counter;
    }
}