/**
 * https://leetcode.com/problems/reverse-linked-list/
 * Author: KKDJoseph
 * Method: 经典反转链表，不是很好想
 * 先反转后面的，然后把head移到最后面，再断开head和head前面的元素的环
 * 根据head和head.next的关系连接next到结尾，因为head.next就是head后面反转后的结尾
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 这思路确实不太好想
        // 先反转后面的，然后根据head和head.next的关系来把head移到最后面，再断开环
        if(head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

