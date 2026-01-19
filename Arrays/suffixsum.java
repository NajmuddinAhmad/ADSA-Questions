public class suffixsum {
    // Generate suffix sum array (also called suffix array)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    public static int[] getSuffixSum(int[] arr) {
        int[] suffix = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + arr[i];
        }
        
        return suffix;
    }
    
    // 2D Suffix sum for matrix
    public static int[][] getSuffixSum2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] suffix = new int[m + 1][n + 1];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suffix[i][j] = matrix[i][j] + suffix[i + 1][j] + 
                               suffix[i][j + 1] - suffix[i + 1][j + 1];
            }
        }
        
        return suffix;
    }
    
    // Get sum of range using suffix sum
    public static int getRangeSum(int[] suffix, int left, int right) {
        if (right == suffix.length - 1) {
            return suffix[left];
        }
        return suffix[left] - suffix[right + 1];
    }
    
    // Find left pointer for given right pointer using suffix sum
    public static int[] getLeftPointers(int[] arr, int[] suffix) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = i;
        }
        return result;
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    // Helper method to print 2D array
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array:");
        printArray(arr);
        
        int[] suffix = getSuffixSum(arr);
        System.out.println("Suffix sum array:");
        printArray(suffix);
        
        System.out.println("\nRange sum from index 1 to 3: " + getRangeSum(suffix, 1, 3)); // 2+3+4 = 9
        System.out.println("Range sum from index 0 to 2: " + getRangeSum(suffix, 0, 2)); // 1+2+3 = 6
        System.out.println("Range sum from index 2 to 4: " + getRangeSum(suffix, 2, 4)); // 3+4+5 = 12
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\nOriginal 2D matrix:");
        printMatrix(matrix);
        
        int[][] suffix2D = getSuffixSum2D(matrix);
        System.out.println("Suffix sum 2D matrix:");
        printMatrix(suffix2D);
    }
}
