public class addTwoNumbers {
    // LeetCode Problem 2 - Add Two Numbers
    // Given two linked lists representing numbers in reverse order
    // Return sum as linked list in reverse order
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            int digit = sum % 10;
            
            current.next = new ListNode(digit);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    // Display list
    public static void display(ListNode head) {
        ListNode current = head;
        System.out.print("Result: ");
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        // Example 1: l1 = [2,4,3], l2 = [5,6,4]
        // Represents 342 + 465 = 807
        // Result: [7,0,8] (807 in reverse)
        
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        ListNode result = addTwoNumbers(l1, l2);
        display(result); // Output: 7 -> 0 -> 8 -> null
        
        // Example 2: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(9);
        l3.next.next.next.next = new ListNode(9);
        l3.next.next.next.next.next = new ListNode(9);
        l3.next.next.next.next.next.next = new ListNode(9);
        
        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);
        l4.next.next = new ListNode(9);
        l4.next.next.next = new ListNode(9);
        
        ListNode result2 = addTwoNumbers(l3, l4);
        display(result2); // Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1 -> null
    }
}
