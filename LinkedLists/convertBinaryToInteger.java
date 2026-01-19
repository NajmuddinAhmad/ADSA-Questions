// Convert Binary Number in Linked List to Integer (LeetCode 1290)
public class convertBinaryToInteger {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Method 1: Build string then convert
    public static int getDecimalValue(ListNode head) {
        StringBuilder binary = new StringBuilder();
        ListNode current = head;
        
        while (current != null) {
            binary.append(current.val);
            current = current.next;
        }
        
        return Integer.parseInt(binary.toString(), 2);
    }
    
    // Method 2: Bit manipulation
    public static int getDecimalValueBit(ListNode head) {
        int result = 0;
        ListNode current = head;
        
        while (current != null) {
            result = result * 2 + current.val;
            current = current.next;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Binary: 1010 = 10 in decimal
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        
        System.out.println("Decimal value: " + getDecimalValue(head));    // 10
        System.out.println("Decimal value (bit): " + getDecimalValueBit(head)); // 10
        
        // Binary: 10011 = 19 in decimal
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(0);
        head2.next.next.next = new ListNode(1);
        head2.next.next.next.next = new ListNode(1);
        
        System.out.println("Decimal value: " + getDecimalValue(head2));    // 19
    }
}
