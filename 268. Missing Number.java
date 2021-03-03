/**
 * https://leetcode.com/problems/missing-number/
 * Author: KKDJoseph
 * Method: super easy nothing to say
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for(int i : nums) sum -= i;
        return sum;
    }
}