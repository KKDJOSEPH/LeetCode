/**
 * https://leetcode.com/problems/roman-to-integer/
 * Author: KKDJoseph
 * Method: 虽然和12很相似，但也有不同的地方
 * 你需要不断的截取子字符串，所以每次截取之前你都要判断是否还能继续截取了
 *
 * Time Complexity: O(1) 因为这和num无关，遍历的数组nums是固定大小的，所以上限是常数
 * Space Complexity: O(1)
 */

class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] value = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int answer = 0;
        for(int i=value.length-1; i>=0 && s.length() > 0; i--){
            String temp = value[i];
            if(s.length() < temp.length()) continue;
            String temps = s.substring(0, temp.length());
            while(temps.equals(temp)){
                s = s.substring(temp.length());
                answer += nums[i];
                if(s.length() < temp.length()) break;
                temps = s.substring(0, temp.length());
            }
        }
        return answer;
    }
}