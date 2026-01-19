// Rotate List (LeetCode 61)
public class rotateList {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Find length
        int length = 0;
        ListNode current = head;
        ListNode tail = null;
        
        while (current != null) {
            length++;
            tail = current;
            current = current.next;
        }
        
        // Normalize k
        k = k % length;
        if (k == 0) return head;
        
        // Find node before rotation point
        current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }
        
        // Rotate
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;
        
        return newHead;
    }
    
    // Display list
    public static void display(ListNode head) {
        ListNode current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Original list:");
        display(head);
        
        head = rotateRight(head, 2);
        System.out.println("After rotating right by 2:");
        display(head); // Output: 4 -> 5 -> 1 -> 2 -> 3 -> null
    }
}
