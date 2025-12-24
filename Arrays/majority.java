import java.util.Arrays;

public class majority {
    // LeetCode 169: Majority Element
    // Link: https://leetcode.com/problems/majority-element/
    // Brief: Find the element occurring more than n/2 times; sorting places it at the middle index.

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            int first = 0;
            int last = nums.length;
            int mid = (first + last) / 2;
            return nums[mid];
        }
    }
}
