import java.util.ArrayList;
import java.util.Collections;

public class squareSortedArray {
    //Solved using 2 pointer and In this Question i also used the merge two sorted array approach
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();

        // Step 1: Separate negative and positive numbers and square and store it
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negative.add(nums[i] * nums[i]);   
            } else {
                positive.add(nums[i] * nums[i]); 
            }
        }

        // Step 2: Reverse negative list (because squares are in decreasing order)
        Collections.reverse(negative);

        // Step 3: Merge two sorted lists
        int i = 0, j = 0, idx = 0;
        int[] result = new int[n];

        while (i < negative.size() && j < positive.size()) {
            if (negative.get(i) < positive.get(j)) {
                result[idx] = negative.get(i);
                i++;
                idx++;
            } else {
                result[idx] = positive.get(j);
                j++;
                idx++;
            }
        }

        // Step 4: Add remaining elements
        while (i < negative.size()) {
            result[idx] = negative.get(i);
            i++;
            idx++;
        }

        while (j < positive.size()) {
            result[idx] = positive.get(j);
            j++;
            idx++;
        }

        return result;
    }
}
}
