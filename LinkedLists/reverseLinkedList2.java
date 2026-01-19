// Reverse Linked List II (LeetCode 92)
// Reverse nodes from position left to right
public class reverseLinkedList2 {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Reach node before left position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode current = prev.next;
        
        // Reverse nodes between left and right
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        
        return dummy.next;
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
        
        head = reverseBetween(head, 2, 4);
        System.out.println("After reversing from position 2 to 4:");
        display(head); // Output: 1 -> 4 -> 3 -> 2 -> 5 -> null
    }
}
