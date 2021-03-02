/**
 * https://leetcode.com/problems/palindrome-permutation/
 * Author: KKDJoseph
 * Method: 最多有一个落单的，要注意这个string不一定都是字母，而且也没说大小写，所以还是用map吧
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public boolean canPermutePalindrome(String s) {
        int counter = 0;
        Map<Character, Integer> map = new HashMap();
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(char i : map.keySet()){
            if(map.get(i) % 2 != 0) counter++;
        }
        if(counter <= 1) return true;
        return false;
    }
}
