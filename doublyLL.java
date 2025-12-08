
public class doublyLL {

    class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteLast(int data){
        Node temp = head;
        while(temp.next != null){
            temp.next = temp;
        }
        temp.prev.next = null;
    }

    public void deleteFirst(int data){
        
        if (head.next == null) { 
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        doublyLL dll = new doublyLL();
        dll.insertFront(4);
        dll.insertFront(6);
        dll.insertFront(8);

        dll.insertEnd(10);

        dll.print();
    }

}
