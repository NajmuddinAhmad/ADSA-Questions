public class maxProductSubarray {
    // Find maximum product of contiguous subarray
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // If current number is negative, swap max and min
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            // Update max and min products
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            
            // Update result
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
    
    // Method to also return the subarray
    public static int[] maxProductSubarrayWithIndices(int[] nums) {
        if (nums.length == 0) return new int[]{0};
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            if (nums[i] > maxProduct * nums[i]) {
                maxProduct = nums[i];
                tempStart = i;
            } else {
                maxProduct = maxProduct * nums[i];
            }
            
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            
            if (maxProduct > result) {
                result = maxProduct;
                start = tempStart;
                end = i;
            }
        }
        
        return new int[]{result, start, end};
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2, 3, -2, 4};
        System.out.println("Max product in [2,3,-2,4]: " + maxProduct(arr1)); // Output: 6
        
        int[] arr2 = {-2};
        System.out.println("Max product in [-2]: " + maxProduct(arr2)); // Output: -2
        
        int[] arr3 = {0, 2};
        System.out.println("Max product in [0,2]: " + maxProduct(arr3)); // Output: 2
        
        int[] arr4 = {-2, 3, -4};
        System.out.println("Max product in [-2,3,-4]: " + maxProduct(arr4)); // Output: 24
        
        int[] arr5 = {2, 3, -2, 4};
        int[] result = maxProductSubarrayWithIndices(arr5);
        System.out.println("Max product with subarray in [2,3,-2,4]: " + result[0] + " (indices " + result[1] + " to " + result[2] + ")");
    }
}
