// Reorder List (LeetCode 143)
// Reorder list: L0 -> L1 -> ... -> Ln-1 -> Ln becomes L0 -> Ln -> L1 -> Ln-1 -> ...
public class reorderList {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static void reorderListInPlace(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        // Step 3: Merge two halves
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode nextFirst = first.next;
            ListNode nextSecond = second.next;
            
            first.next = second;
            second.next = nextFirst;
            
            first = nextFirst;
            second = nextSecond;
        }
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
        
        reorderListInPlace(head);
        System.out.println("Reordered list:");
        display(head); // Output: 1 -> 5 -> 2 -> 4 -> 3 -> null
    }
}
