// LeetCode 876: Middle of the Linked List
// Link: https://leetcode.com/problems/middle-of-the-linked-list/
// Brief: Fast and slow pointers to return the second middle in even-length lists.

public class linkedlist1 {
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
        public ListNode middleNode(ListNode head) {
            ListNode slow = head; 
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
