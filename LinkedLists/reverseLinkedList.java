public class reverseLinkedList {
    // Reverse a linked list (LeetCode 206)
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Method 1: Iterative
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
    
    // Method 2: Recursive
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    // Method 3: Using Stack
    public static ListNode reverseUsingStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        java.util.Stack<ListNode> stack = new java.util.Stack<>();
        ListNode current = head;
        
        // Push all nodes to stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        // Pop from stack and build new list
        ListNode newHead = stack.pop();
        current = newHead;
        
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        
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
        
        display(head);
        
        head = reverseIterative(head);
        display(head); // Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}
