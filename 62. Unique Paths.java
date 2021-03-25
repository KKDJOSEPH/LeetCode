/**
 * https://leetcode.com/problems/unique-paths/
 * Author: KKDJoseph
 * Method: 一开始recursion超时，由于不需要保存路径，而且中间有重复操作，想到dp
 *
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 */

class Solution {
    // 一开始用recursion超时了
    // dp的思路是，由于只能往右或者往下走，那么第一排和第一列的位置都只有一种方式到达
    // 对于其他位置，只需要把左边和上边的元素求和即可
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
        }

        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 1;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}