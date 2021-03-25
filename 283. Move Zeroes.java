/**
 * https://leetcode.com/problems/move-zeroes/
 * Author: KKDJoseph
 * Method: 走一遍就行，把不是0的数从第0位置开始往后填入，最后把剩余位置置0
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        int index = 0;
        for(int i : nums){
            if(i != 0){
                nums[index] = i;
                index++;
            }
        }

        for(int i=index; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}