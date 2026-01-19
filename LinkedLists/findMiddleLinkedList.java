public class findMiddleLinkedList {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Method 1: Two pointer (slow and fast)
    public static int findMiddle(Node head) {
        if (head == null) return -1;
        
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
    
    // Method 2: Count and traverse
    public static int findMiddleWithCount(Node head) {
        int count = 0;
        Node current = head;
        
        // Count total nodes
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Traverse to middle
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    // Method 3: Return middle node
    public static Node findMiddleNode(Node head) {
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.println("Middle element (odd length): " + findMiddle(head)); // Output: 3
        
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        
        System.out.println("Middle element (even length): " + findMiddle(head2)); // Output: 3
        
        System.out.println("Middle node data (using count method): " + findMiddleWithCount(head)); // Output: 3
    }
}
