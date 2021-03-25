/**
 * https://leetcode.com/problems/valid-anagram/
 * Author: KKDJoseph
 * Method: ez
 *
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] temps = s.toCharArray();
        Arrays.sort(temps);
        char[] tempt = t.toCharArray();
        Arrays.sort(tempt);
        String ss = String.valueOf(temps);
        String tt = String.valueOf(tempt);
        return ss.equals(tt);
    }
}