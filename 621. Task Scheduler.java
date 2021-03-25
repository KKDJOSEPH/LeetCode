/**
 * https://leetcode.com/problems/task-scheduler/
 * Author: KKDJoseph
 * Method: 很有意思的题，给定很多个不同的task，和相同task之间的必要间隔
 * 问最少的工作时间是多少
 * 贪心算法，先找到所有task的出现次数，然后排序，最大的出现次数意味着有max-1个空档
 * 也就是n*(max-1)个最大空闲
 * 那么将剩余的task插入这些空闲即可
 * 需要注意的是，可能有出现次数也为max的task，明显max-1的空挡不够，他们还会插入最后一个task的后面
 * 但这时他们就不需要额外空挡了，所以你要判断idle和当前的frequency哪个小，也就是
 * 究竟占用了几个idle，别减多了
 * 再就是n可能很小，也就是idle不够多，那你要保证idle剪完还是大于等于0的，不可能小于0
 * 多的task查到最后面就行
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    // 贪心问题
    // 找到最大的出现次数，以它为基础往里插入，最多的idle空间就是中间的空，也就是max-1个空，每个空长n
    // 然后往里插入，正常你是直接把其他的减去就行，但是防止有task出现次数和max一样多，这样的task除了插完中间的空
    // 还会在结尾插入，但那个就不用idle了，所以要比较中间的空和当前task出现次数哪个小
    // 要注意idle是大于0的.因为有可能n是0，那你就没有减的必要了
    public int leastInterval(char[] tasks, int n) {
        int[] nums = new int[26];
        for(char i : tasks){
            nums[i-'A']++;
        }

        Arrays.sort(nums);
        int max = nums[25];
        int maxidle = (max-1)*n;
        for(int i=nums.length-2; i>=0 && maxidle>0 && nums[i]>0; i--){
            maxidle -= Math.min(max-1, nums[i]);
        }
        maxidle = Math.max(0, maxidle);
        return maxidle + tasks.length;
    }
}