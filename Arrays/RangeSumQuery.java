public class RangeSumQuery {
    // Range Sum Query - Immutable (LeetCode 303)
    // Time Complexity: O(1) for query, O(n) for construction
    // Space Complexity: O(n)
    
    static class NumArray {
        private int[] prefix;
        
        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            prefix[0] = 0;
            
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }
        
        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }
    
    // 2D Range Sum Query - Immutable
    static class NumMatrix {
        private int[][] prefix;
        
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            prefix = new int[m + 1][n + 1];
            
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + 
                                   prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - 
                   prefix[row2 + 1][col1] + prefix[row1][col1];
        }
    }
    
    public static void main(String[] args) {
        // Test 1D Range Sum Query
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        
        System.out.println("1D Range Sum Query:");
        System.out.println("sumRange(0, 2): " + numArray.sumRange(0, 2)); // -2 + 0 + 3 = 1
        System.out.println("sumRange(2, 5): " + numArray.sumRange(2, 5)); // 3 + (-5) + 2 + (-1) = -1
        System.out.println("sumRange(0, 5): " + numArray.sumRange(0, 5)); // -2 + 0 + 3 + (-5) + 2 + (-1) = -3
        
        // Test 2D Range Sum Query
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7}
        };
        
        NumMatrix numMatrix = new NumMatrix(matrix);
        
        System.out.println("\n2D Range Sum Query:");
        System.out.println("sumRegion(2, 1, 4, 3): " + numMatrix.sumRegion(2, 1, 4, 3)); // 8
        System.out.println("sumRegion(1, 1, 2, 2): " + numMatrix.sumRegion(1, 1, 2, 2)); // 11
        System.out.println("sumRegion(1, 2, 2, 4): " + numMatrix.sumRegion(1, 2, 2, 4)); // 12
    }
}
