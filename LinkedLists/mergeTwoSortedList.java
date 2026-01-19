public class mergeTwoSortedList {
    // Merge two sorted lists (LeetCode 21)
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    // Merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next;
    }
    
    // Display list
    public static void display(ListNode head) {
        ListNode current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        System.out.println("List 1:");
        display(list1);
        
        System.out.println("List 2:");
        display(list2);
        
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.println("Merged:");
        display(merged); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }
}
