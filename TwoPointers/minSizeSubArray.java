// LeetCode 209: Minimum Size Subarray Sum
// Link: https://leetcode.com/problems/minimum-size-subarray-sum/
// Brief: Sliding window grows and shrinks to find the shortest subarray with sum >= target.
public class minSizeSubArray {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int n = nums.length;
            int sum = 0;
            int result = Integer.MAX_VALUE;
            int low = 0;
            int high = 0;

            for (high = 0; high < n; high++) {
                sum = sum + nums[high];

                while (sum >= target) {
                    result = Math.min(result, high - low + 1);
                    sum =sum - nums[low];
                    low++;
                }
            }

            if (result == Integer.MAX_VALUE) {
                return 0;
            } else {
                return result;
            }

        }
    }
}
