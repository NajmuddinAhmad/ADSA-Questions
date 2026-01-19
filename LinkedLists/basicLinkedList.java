public class basicLinkedList {
    // Basic Node class for LinkedList
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // LinkedList class
    static class LinkedList {
        Node head;
        
        // Insert at beginning
        public void insertAtStart(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        
        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                head = newNode;
                return;
            }
            
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        
        // Display LinkedList
        public void display() {
            Node current = head;
            System.out.print("LinkedList: ");
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.display(); // Output: 1 -> 2 -> 3 -> null
        
        list.insertAtStart(0);
        list.display(); // Output: 0 -> 1 -> 2 -> 3 -> null
    }
}
