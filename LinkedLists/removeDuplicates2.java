// Remove Duplicates from Sorted List II (LeetCode 82)
// Remove all nodes that have duplicate numbers
public class removeDuplicates2 {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            // If duplicate found, skip all nodes with same value
            if (current.next != null && current.val == current.next.val) {
                int duplicateVal = current.val;
                while (current != null && current.val == duplicateVal) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        
        System.out.println("Before removing duplicates:");
        display(head);
        
        head = deleteDuplicates(head);
        System.out.println("After removing duplicates:");
        display(head); // Output: 1 -> null
    }
}
