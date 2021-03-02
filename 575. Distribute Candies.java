/**
 * https://leetcode.com/problems/distribute-candies/
 * Author: KKDJoseph
 * Method: 其实你只用比较糖的种类和n/2哪个小就好了
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet();
        for(int i : candyType){
            set.add(i);
        }
        return Math.min(set.size(), candyType.length/2);
    }
}