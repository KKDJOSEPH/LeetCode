/**
 * https://leetcode.com/problems/generate-parentheses/
 * Author: KKDJoseph
 * Method: 给定括号（）的对数，有多少种排列
 * 需要注意，这不是backtracking，要一直保证left >= right， 不用清除left给right腾地方
 * Time Complexity: kind of hard to explain the time complexity for a backtracking problem.
 * worst case is exponential. O(2^n)
 * Space Complexity: O(n) / O(1)
 */

class Solution {
    // 这个不算backtracking，他不能回溯，因为他要保证left永远大于等于right
    // 这更像是一个recursion遍历，left不用给right腾地方
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList();
        helper(answer, "", n, 0, 0);
        return answer;
    }

    public void helper(List<String> answer, String cur, int n, int left, int right){
        if(cur.length() == 2*n){
            answer.add(new String(cur));
            return;
        }

        if(left < n) helper(answer, cur+"(", n, left+1, right);
        if(right < left) helper(answer, cur+")", n, left, right+1);
    }
}