public class insertStartLinkedList {
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
        
        // Insert at start
        public void insertAtStart(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
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
        
        list.insertAtStart(3);
        list.display(); // Output: 3 -> null
        
        list.insertAtStart(2);
        list.display(); // Output: 2 -> 3 -> null
        
        list.insertAtStart(1);
        list.display(); // Output: 1 -> 2 -> 3 -> null
        
        list.insertAtStart(0);
        list.display(); // Output: 0 -> 1 -> 2 -> 3 -> null
    }
}
