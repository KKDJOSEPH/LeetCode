/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * Author: KKDJoseph
 * Method: 目标是把奇偶位置的元素分开，一开始想的是用fast和slow双指针，但是想到.next.next会有null的情况
 * 所以就只用一个指针往下走，两个指针用来记录odd和even
 * 取巧的一点是，每次得到了当前的odd和even，你要让temp指针往下走完之后，把odd与他的next断开，因为他的next是even的节点
 * 不断开就会成环，两串就会交织在一起
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode answer = new ListNode(-1);
        ListNode odd = answer;
        ListNode answer2 = new ListNode(-1);
        ListNode even = answer2;
        ListNode temp = head;
        while(temp != null){
            odd.next = temp;
            odd = odd.next;
            temp = temp.next;
            odd.next = null;
            if(temp != null){
                even.next = temp;
                even = even.next;
                temp = temp.next;
                even.next = null;
            }
        }
        odd.next = answer2.next;

        return answer.next;
    }
}