/**
 * https://leetcode.com/problems/integer-to-roman/
 * Author: KKDJoseph
 * Method: 很有意思的一道题，你需要把给定的整数和5的倍数和对应的4和9都写出来
 * 写出一个map
 * 然后从大到小遍历，逮到一个使劲减，减到不能减为止
 * 从小到大就没法判断了
 *
 * Time Complexity: O(1) 因为这和num无关，遍历的数组nums是固定大小的，所以上限是常数
 * Space Complexity: O(1)
 */

class Solution {
    // 从大到小，逮到一个使劲减，减到不能减为止
    public String intToRoman(int num) {
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] value = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String answer = "";
        for(int i=nums.length-1; i>=0; i--){
            while(num >= nums[i]){
                answer += value[i];
                num -= nums[i];
            }
        }
        return answer;
    }
}