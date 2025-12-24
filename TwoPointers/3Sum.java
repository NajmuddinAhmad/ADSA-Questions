// LeetCode 15: 3Sum
// Link: https://leetcode.com/problems/3sum/
// Brief: Find unique triplets summing to zero using sorting and two-pointer sweep while skipping duplicates.
public class 3Sum {
    //This Question is also solve using two pointer with some basic changes like take one extra variable i and fixing it and applying two pointer and solving the problem in this Question we are also tackling for duplicates values
    class Solution {
        public java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
            java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
            int n = nums.length;
            java.util.Arrays.sort(nums);  //sorting the given array for easy applying two pointer 

            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]){  // checking duplicates for third fixed variable 
                    continue;
                }

                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        result.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]){ // checking duplicate value and avoiding it 
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){ // checking duplicate value and avoiding it 
                            right--;
                        }
                        // this is use if there is no duplicate value so same as two pointer we more forward and backward as we are doing in older Questions
                        left++;
                        right--;
                    } else if (sum < 0) {  // here if the answer is less then zero so just increase the left value
                        left++;
                    } else {  // here if the answer is greater than zero then so just decrease the right value
                        right--;
                    }
                }
            }
            return result;
        }
    }
}
