/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Author: KKDJoseph
 * Method: 一次就能过，注意temp指向的是l1的地址，所以后续l1更改指针的位置也无所谓
 *
 * Time Complexity: O(n+m)
 * Space Complexity: O(n+m)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(-1);
        ListNode temp = answer;
        while(l1!=null || l2!=null){
            if(l1 == null){
                temp.next = l2;
                break;
            }

            if(l2 == null){
                temp.next = l1;
                break;
            }

            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        return answer.next;
    }
}