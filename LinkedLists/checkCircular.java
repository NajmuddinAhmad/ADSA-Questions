public class checkCircular {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Method 1: Floyd's Cycle Detection (Tortoise and Hare)
    public static boolean isCircular(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        
        return false;
    }
    
    // Method 2: Using HashSet
    public static boolean isCircularUsingSet(Node head) {
        if (head == null) return false;
        
        java.util.Set<Node> visited = new java.util.HashSet<>();
        Node current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        
        return false;
    }
    
    // Get start node of cycle
    public static Node findCycleStart(Node head) {
        if (head == null) return null;
        
        Node slow = head, fast = head;
        
        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Found cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Start of cycle
            }
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        System.out.println("Is circular (no cycle): " + isCircular(head)); // Output: false
        
        // Create circular list
        head.next.next.next.next = head;
        System.out.println("Is circular (with cycle): " + isCircular(head)); // Output: true
        
        // Create cycle at middle
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = head2.next; // Cycle to 2
        
        System.out.println("Cycle start data: " + findCycleStart(head2).data); // Output: 2
    }
}
