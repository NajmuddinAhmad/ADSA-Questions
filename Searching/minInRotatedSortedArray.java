public class minInRotatedSortedArray {
    // Find minimum element in rotated sorted array using binary search
    // Time Complexity: O(log n)
    
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            // If array is already sorted in this range
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            
            int mid = left + (right - left) / 2;
            
            // Check if mid is the minimum
            if (nums[mid] > nums[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum in [3,4,5,1,2]: " + findMin(arr1)); // Output: 1
        
        int[] arr2 = {2, 1};
        System.out.println("Minimum in [2,1]: " + findMin(arr2)); // Output: 1
        
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Minimum in [1,2,3,4,5]: " + findMin(arr3)); // Output: 1
    }
}
