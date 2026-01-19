public class rotationCount {
    // Find how many times array has been rotated
    // If array is rotated k times, then minimum element is at index k
    // Time Complexity: O(log n)
    
    public static int countRotations(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        // If array is not rotated
        if (nums[left] < nums[right]) {
            return 0;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid+1 is the minimum element
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            
            // Check if mid is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println("Array [3,4,5,1,2] has been rotated: " + countRotations(arr1) + " times"); // Output: 3
        
        int[] arr2 = {2, 1};
        System.out.println("Array [2,1] has been rotated: " + countRotations(arr2) + " times"); // Output: 1
        
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Array [1,2,3,4,5] has been rotated: " + countRotations(arr3) + " times"); // Output: 0
    }
}
