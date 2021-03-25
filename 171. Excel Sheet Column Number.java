/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Author: KKDJoseph
 * Method: 26进制，多观察testcase，每一位要称26^n
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    // 26进制，每一位都要乘26^i
    public int titleToNumber(String columnTitle) {
        int answer = 0;
        for(int i=0; i<columnTitle.length(); i++){
            int temp = columnTitle.charAt(i)-'A'+1;
            answer += temp * Math.pow(26, columnTitle.length()-i-1);
        }
        return answer;
    }
}