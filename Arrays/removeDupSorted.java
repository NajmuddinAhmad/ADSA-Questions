// LeetCode 26: Remove Duplicates from Sorted Array
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Brief: In-place two-pointer compaction keeps one of each unique value.
public class removeDupSorted {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int i = 0;
            int j = 1;
            int result = 1;
            while(j < n){

                if(nums[j] == nums[j-1]){
                    j++;
                }
                else if(nums[j] != nums[j-1]){
                    nums[i+1] = nums[j];
                    result++;
                    i++;
                    j++;
                }
            }
            return result;
        }
    }
}
