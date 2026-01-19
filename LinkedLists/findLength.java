// Find length of linked list
public class findLength {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Get length iteratively
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        
        while (current != null) {
            length++;
            current = current.next;
        }
        
        return length;
    }
    
    // Get length recursively
    public static int getLengthRecursive(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        return 1 + getLengthRecursive(head.next);
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("Length (iterative): " + getLength(head));       // 5
        System.out.println("Length (recursive): " + getLengthRecursive(head)); // 5
    }
}
