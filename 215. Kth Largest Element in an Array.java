/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Author: KKDJoseph
 * Method: 排序输出空位置
 *
 * Time Complexity: O(nlogn) O(nlogk)
 * Space Complexity: O(1)
 */

class Solution {
    // 排序的平均时长是nlogn, 当然也可以维护一个大小为k的小根堆，输出队首元素
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution {
    // 维护一个大小为k的小根堆
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        for(int n : nums){
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }
        return heap.poll();
    }
}