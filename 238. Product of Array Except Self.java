/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Author: KKDJoseph
 * Method: 除去自己，其他元素的乘积。要判断好0的个数，1个，多于1个？
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int counter = 0;
        int product = 1;
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                counter++;
                index = i;
            }
            else product *= nums[i];
        }

        if(counter>=2) return new int[nums.length];
        int[] answer = new int[nums.length];
        if(counter == 1){
            answer[index] = product;
            return answer;
        }

        for(int i=0; i<nums.length; i++){
            answer[i] = product/nums[i];
        }
        return answer;
    }
}