public class removeDupSorted {
    // Remove duplicates from sorted linked list (LeetCode 83)
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Remove duplicates
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        
        System.out.println("Before removing duplicates:");
        display(head);
        
        head = deleteDuplicates(head);
        System.out.println("After removing duplicates:");
        display(head); // Output: 1 -> 2 -> 3 -> null
    }
}
