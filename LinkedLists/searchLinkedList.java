// Search in Linked List
public class searchLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Linear search
    public static boolean search(ListNode head, int target) {
        ListNode current = head;
        
        while (current != null) {
            if (current.val == target) {
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    // Find position (1-indexed)
    public static int findPosition(ListNode head, int target) {
        ListNode current = head;
        int position = 1;
        
        while (current != null) {
            if (current.val == target) {
                return position;
            }
            current = current.next;
            position++;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Search for 3: " + search(head, 3));   // true
        System.out.println("Search for 6: " + search(head, 6));   // false
        System.out.println("Position of 3: " + findPosition(head, 3)); // 3
        System.out.println("Position of 1: " + findPosition(head, 1)); // 1
    }
}
