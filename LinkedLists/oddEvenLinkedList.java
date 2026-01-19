public class oddEvenLinkedList {
    // Odd Even Linked List (LeetCode 328)
    // Rearrange list so odd indexed nodes come first, then even indexed nodes
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode odd = head;           // 1st node (odd index)
        ListNode even = head.next;     // 2nd node (even index)
        ListNode evenHead = even;      // Keep track of even head
        
        while (even != null && even.next != null) {
            odd.next = even.next;      // Connect odd nodes
            odd = odd.next;
            
            even.next = odd.next;      // Connect even nodes
            even = even.next;
        }
        
        odd.next = evenHead;           // Connect odd list to even list
        
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
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Original list:");
        display(head);
        
        head = oddEvenList(head);
        System.out.println("After odd-even rearrangement:");
        display(head); // Output: 1 -> 3 -> 5 -> 2 -> 4 -> null
    }
}
