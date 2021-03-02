/**
 * https://leetcode.com/problems/single-row-keyboard/
 * Author: KKDJoseph
 * Method: 记录每个keyword中每个字母出现的位置就好，然后遍历word来算相邻字母位置的间隔，最后加上第一个字母的位置就是一共移动的距离
 *
 * Time Complexity: O(26+k) = O(k)
 * Space Complexity: O(26) = O(1)
 */


class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] board = new int[26];
        char[] temp = keyboard.toCharArray();
        for(int i=0; i<keyboard.length(); i++){
            board[temp[i]-'a'] = i;
        }
        int counter = 0;
        char[] temp2 = word.toCharArray();
        for(int i=1; i<word.length(); i++){
            counter += Math.abs(board[temp2[i]-'a'] - board[temp2[i-1]-'a']);
        }
        return counter + board[temp2[0]-'a'];
    }
}