public class maxInRotatedSortedArray {
    // Find maximum element in rotated sorted array using binary search
    // Time Complexity: O(log n)
    
    public static int findMax(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If middle element is greater than right, max is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Max is in left half (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println("Maximum in [3,4,5,1,2]: " + findMax(arr1)); // Output: 5
        
        int[] arr2 = {2, 1};
        System.out.println("Maximum in [2,1]: " + findMax(arr2)); // Output: 2
        
        int[] arr3 = {1, 2, 3};
        System.out.println("Maximum in [1,2,3]: " + findMax(arr3)); // Output: 3
    }
}
