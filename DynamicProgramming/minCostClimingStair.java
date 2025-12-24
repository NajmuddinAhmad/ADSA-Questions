// LeetCode 746: Min Cost Climbing Stairs
// Link: https://leetcode.com/problems/min-cost-climbing-stairs/
// Brief: Top-down DP choosing min cost from step i via 1 or 2 moves.

import java.util.Arrays;

public class minCostClimingStair {
    class Solution {
        int[] dp;
        public int minCostClimbingStairs(int[] cost) {
            dp = new int[cost.length];
            Arrays.fill(dp, -1);

            return Math.min(helper(0, cost), helper(1, cost));
        }

        public int helper(int idx, int[] cost) {
            if (idx >= cost.length) {
                return 0;
            }
            if (dp[idx] != -1) {
                return dp[idx];
            }

            int first = cost[idx] + helper(idx + 1, cost);
            int second = cost[idx] + helper(idx + 2, cost);

            dp[idx] = Math.min(first, second);
            return dp[idx];
        }
    }
}
