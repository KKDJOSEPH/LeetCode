/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Author: KKDJoseph
 * Method: 看不见head，要删除给定的节点，其实就是改个值然后连接后面就行了，你需要要删除节点的父亲，那就创造一个出来
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}