// LeetCode 3074: Apple Redistribution into Boxes
// Link: https://leetcode.com/problems/apple-redistribution-into-boxes/
// Brief: Given apple counts and box capacities, find the minimum boxes needed using sorting and greedy selection from largest capacities.

import java.util.Arrays;

public class appleRedistribution {
    class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            int sum = 0;
            for (int i = 0; i < apple.length; i++) {
                sum += apple[i];
            }
            Arrays.sort(capacity);
            int count = 0;
            for (int i = capacity.length - 1; i >= 0; i--) {
                sum -= capacity[i];
                count++;

                if (sum <= 0) {
                    break;
                }
            }

            return count;
        }
    }
}
