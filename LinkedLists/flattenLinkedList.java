// Flattening a Linked List (GFG Problem)
// Flatten a linked list where each node has next and child pointer
public class flattenLinkedList {
    static class Node {
        int data;
        Node next;
        Node child;
        
        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }
    
    // Flatten the linked list
    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        head.next = flatten(head.next);
        head = merge(head, head.next);
        head.next = null; // Remove child structure after merging
        
        return head;
    }
    
    // Merge two sorted lists
    private static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        
        Node result;
        
        if (a.data < b.data) {
            result = a;
            result.child = merge(a.child, b);
        } else {
            result = b;
            result.child = merge(a, b.child);
        }
        
        return result;
    }
    
    // Display flattened list
    public static void display(Node head) {
        Node current = head;
        System.out.print("Flattened: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.child;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        // Create a complex linked list
        Node head = new Node(1);
        head.child = new Node(2);
        head.child.child = new Node(3);
        
        head.next = new Node(4);
        head.next.child = new Node(5);
        head.next.child.child = new Node(6);
        
        head.next.next = new Node(7);
        head.next.next.child = new Node(8);
        
        System.out.println("Flattening linked list...");
        head = flatten(head);
        display(head); // Output should be sorted merged list
    }
}
