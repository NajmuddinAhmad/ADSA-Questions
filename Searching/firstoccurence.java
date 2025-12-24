// LeetCode 34: Find First and Last Position of Element in Sorted Array
// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Brief: Modified binary search twice to get leftmost and rightmost indices.
import java.util.*;
public class firstoccurence {
    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        int result1 = FirstSearch(nums, target);
        int result2 = LastSearch(nums, target);
        int [] result = {result1 , result2};
        System.out.println("First occurrence of at index: " + result1+"Last occurrence of at index" +result2);
        System.out.println("Final answer "+Arrays.toString(result));
    }

    public static int FirstSearch(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int LastSearch(int[] nums, int target){
                int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
