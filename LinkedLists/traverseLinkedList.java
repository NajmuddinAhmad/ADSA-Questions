public class traverseLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Traverse using while loop
    public static void traverseIterative(Node head) {
        System.out.print("Traverse (Iterative): ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Traverse using recursion
    public static void traverseRecursive(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.data + " -> ");
        traverseRecursive(head.next);
    }
    
    // Reverse traverse using recursion
    public static void reverseTraverse(Node head) {
        if (head == null) {
            return;
        }
        reverseTraverse(head.next);
        System.out.print(head.data + " -> ");
    }
    
    // Count nodes
    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        traverseIterative(head);
        
        System.out.print("Traverse (Recursive): ");
        traverseRecursive(head);
        
        System.out.print("Reverse Traverse: ");
        reverseTraverse(head);
        System.out.println("null");
        
        System.out.println("Total nodes: " + countNodes(head)); // Output: 4
    }
}
