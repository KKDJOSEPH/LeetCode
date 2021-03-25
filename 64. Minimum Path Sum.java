/**
 * https://leetcode.com/problems/minimum-path-sum/
 * Author: KKDJoseph
 * Method: DFS会超时
 * DP：base case: 两条边线上都是前缀和，因为没有其他路能走到他们
 * 其他内部位置就是看左边和上边谁小就从谁那走r
 *
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */

class Solution {
    // base case: 两条边线上都是前缀和，因为没有其他路能走到他们
    // 其他内部位置就是看左边和上边谁小就从谁那走
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1; i<grid.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j=1; j<grid[0].length; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}