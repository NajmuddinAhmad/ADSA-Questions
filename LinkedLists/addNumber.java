// Add Number - GFG Problem
// Add a number to the linked list
public class addNumber {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add a number to linked list
    public static Node addNumberToList(Node head, int num) {
        if (head == null) {
            return new Node(num);
        }
        
        // Find last node and add number
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(num);
        
        return head;
    }
    
    // Display
    public static void display(Node head) {
        Node current = head;
        System.out.print("List: ");
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
        
        display(head);
        
        head = addNumberToList(head, 4);
        head = addNumberToList(head, 5);
        
        display(head); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}
