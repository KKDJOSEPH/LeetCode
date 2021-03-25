/**
 * https://leetcode.com/problems/add-digits/
 * Author: KKDJoseph
 * Method: 把每一位相加直到结果小于等于9
 *数学方法，类似3的性质
 * 如果能整除9， 那最后求和的结果一定是9，否则就是对9的取余，
 * 但要注意0对9取余还是9，但实际应该输出0
 * Time Complexity: O(n) / O(1)
 * Space Complexity: O(1)
 */

class Solution {
    public int addDigits(int num) {
        int digit = 0;
        while(num != 0){
            digit += num%10;
            num = num/10;
            if(num == 0 && digit > 9){
                num = digit;
                digit = 0;
            }
        }
        return digit;
    }
}

class Solution {
    public int addDigits(int num) {
        if(num == 0) return num;
        if(num % 9 == 0) return 9; // 如果整除9，那么各位置求和也是9
        return num%9;
    }
}