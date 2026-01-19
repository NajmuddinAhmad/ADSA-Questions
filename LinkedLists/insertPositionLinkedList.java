public class insertPositionLinkedList {
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
        
        // Insert at specific position (1-indexed)
        public void insertAtPosition(int data, int position) {
            Node newNode = new Node(data);
            
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }
            
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            
            if (current == null) {
                System.out.println("Position out of range");
                return;
            }
            
            newNode.next = current.next;
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
        
        list.insertAtPosition(1, 1);
        list.display(); // Output: 1 -> null
        
        list.insertAtPosition(2, 2);
        list.display(); // Output: 1 -> 2 -> null
        
        list.insertAtPosition(4, 3);
        list.display(); // Output: 1 -> 2 -> 4 -> null
        
        list.insertAtPosition(3, 3);
        list.display(); // Output: 1 -> 2 -> 3 -> 4 -> null
    }
}
