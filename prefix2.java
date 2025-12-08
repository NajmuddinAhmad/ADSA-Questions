import java.util.*;

public class prefix2 {
    private int[] prefixSum;

    // Constructor: builds prefix sum array
    public prefix2(int[] nums) {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    // Returns sum from index left to right (inclusive)
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        prefix2 obj = new prefix2(nums);
        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}
