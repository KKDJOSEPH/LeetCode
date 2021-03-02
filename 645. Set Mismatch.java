/**
 * https://leetcode.com/problems/set-mismatch/
 * Author: KKDJoseph
 * Method: 挺简单的。。就照着题干做一遍就行
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */



class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] temp = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            temp[nums[i]]++;
        }
        int[] answer = new int[2];
        for(int i=1; i<=nums.length; i++){
            if(temp[i] == 2) answer[0] = i;
            if(temp[i] == 0) answer[1] = i;
        }
        return answer;
    }
}