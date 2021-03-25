/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Author: KKDJoseph
 * Method: 要转置这个矩阵，首先上下对称行交换
 * 再根据对角线两两对称交换
 * 注意不能走完全部，走一半就够，要不就会白交换了，因为又交换回去了
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        for(int i=0; i<prices.length-1; i++){
            answer += Math.max(0, prices[i+1] - prices[i]);
        }
        return answer;
    }
}