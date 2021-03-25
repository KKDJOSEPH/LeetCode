/**
 * https://leetcode.com/problems/majority-element/solution/
 * Author: KKDJoseph
 * Method: 要转置这个矩阵，首先上下对称行交换
 * 再根据对角线两两对称交换
 * 注意不能走完全部，走一半就够，要不就会白交换了，因为又交换回去了
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */


class Solution {
    // 先上下对称行交换
    // 再根据对角线两两交换
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length/2; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1-i];
            matrix[matrix.length-1-i] = temp;
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}