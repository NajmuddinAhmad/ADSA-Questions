public class insertEndLinkedList {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedList {
        Node head;
        
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
        
        // Display
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
        list.display(); // Output: 1 -> null
        
        list.insertAtEnd(2);
        list.display(); // Output: 1 -> 2 -> null
        
        list.insertAtEnd(3);
        list.display(); // Output: 1 -> 2 -> 3 -> null
        
        list.insertAtEnd(4);
        list.display(); // Output: 1 -> 2 -> 3 -> 4 -> null
    }
}
