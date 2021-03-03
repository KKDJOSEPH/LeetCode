/**
 * https://leetcode.com/problems/single-number/
 * Author: KKDJoseph
 * Method: 排序或位操作，位操作确实更巧妙
 *
 * Time Complexity: 排序： O(nlogn)  位操作： O(n) a^0=a a^a=0
 * Space Complexity: O(1)
 */


class Solution {
    public int singleNumber(int[] nums) {
        // 一开始想到的是排序，如果当前与下一个一样，i+=2, 否则返回当前位置的值
        // 如果走过一遍都没有，那就是最大值是唯一的，或者是数组只有一个值
        // 但排序需要nlogn的时间，有点慢了，答案的位操作更巧妙
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] != nums[i+1]) return nums[i];
            else i++;
        }
        return nums[nums.length-1];
    }
}

