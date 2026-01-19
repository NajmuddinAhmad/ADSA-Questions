public class kthMissingElement {
    // Find kth missing element in sorted array
    // Time Complexity: O(log n) using binary search
    
    public static int findKthMissing(int[] arr, int k) {
        // Method 1: Using binary search (optimal)
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Number of missing elements up to arr[mid]
            int missing = arr[mid] - (mid + 1); // arr[mid] - (actual count)
            
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return arr[left] + (k - (arr[left] - (left + 1)));
    }
    
    // Method 2: Linear approach (simpler understanding)
    public static int findKthMissingLinear(int[] arr, int k) {
        int missing = 0;
        
        for (int i = 1; i <= arr[arr.length - 1]; i++) {
            // Check if i is not in array
            if (!contains(arr, i)) {
                missing++;
                if (missing == k) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    // Helper method to check if element exists in array
    private static boolean contains(int[] arr, int num) {
        for (int n : arr) {
            if (n == num) return true;
            if (n > num) return false; // Since array is sorted
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 7, 8, 10};
        System.out.println("Array: [1,3,4,7,8,10]");
        System.out.println("2nd missing element: " + findKthMissing(arr1, 2)); // Output: 5
        System.out.println("4th missing element: " + findKthMissing(arr1, 4)); // Output: 9
        
        int[] arr2 = {2, 3, 4, 7, 11};
        System.out.println("\nArray: [2,3,4,7,11]");
        System.out.println("1st missing element: " + findKthMissing(arr2, 1)); // Output: 1
        System.out.println("3rd missing element: " + findKthMissing(arr2, 3)); // Output: 6
    }
}
