public class deleteNode {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Delete at specific position (1-indexed)
    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) return null;
        
        if (position == 1) {
            return head.next; // Delete head
        }
        
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null || current.next == null) {
            System.out.println("Position out of range");
            return head;
        }
        
        current.next = current.next.next;
        return head;
    }
    
    // Delete node with given value
    public static Node deleteByValue(Node head, int value) {
        if (head == null) return null;
        
        if (head.data == value) {
            return head.next;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
        }
        
        return head;
    }
    
    // Delete node given reference to node (LeetCode 237)
    public static void deleteNode(Node node) {
        if (node == null || node.next == null) return;
        
        // Copy next node's data to current node
        node.data = node.next.data;
        // Remove next node
        node.next = node.next.next;
    }
    
    // Display list
    public static void display(Node head) {
        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        display(head);
        
        head = deleteAtPosition(head, 2);
        display(head); // Output: 1 -> 3 -> 4 -> null
        
        head = deleteByValue(head, 4);
        display(head); // Output: 1 -> 3 -> null
        
        head = deleteAtPosition(head, 1);
        display(head); // Output: 3 -> null
    }
}
