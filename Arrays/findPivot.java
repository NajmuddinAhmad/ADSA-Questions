public class findPivot {
    // Find pivot element in array
    // Pivot element is where leftSum == rightSum
    // Time Complexity: O(n)
    // Space Complexity: O(n) or O(1)
    
    // Method 1: Using two arrays for left and right sum
    public static int findPivotIndexMethod1(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        // Calculate left sum
        leftSum[0] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        
        // Calculate right sum
        rightSum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        
        // Find pivot
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        
        return -1;
    }
    
    // Method 2: Optimal approach using total sum
    public static int findPivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        
        return -1;
    }
    
    // Find all pivot elements
    public static java.util.List<Integer> findAllPivots(int[] nums) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int totalSum = 0;
        
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            if (leftSum == rightSum) {
                result.add(i);
            }
            
            leftSum += nums[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Array: [1,7,3,6,5,6]");
        System.out.println("Pivot index: " + findPivotIndex(arr1)); // Output: 3
        
        int[] arr2 = {1, 2, 3};
        System.out.println("\nArray: [1,2,3]");
        System.out.println("Pivot index: " + findPivotIndex(arr2)); // Output: -1
        
        int[] arr3 = {2, 1, -1};
        System.out.println("\nArray: [2,1,-1]");
        System.out.println("Pivot index: " + findPivotIndex(arr3)); // Output: 0
        
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        System.out.println("\nArray: [1,1,1,1,1,1]");
        System.out.println("All pivot indices: " + findAllPivots(arr4)); // Output: [2, 3]
    }
}
