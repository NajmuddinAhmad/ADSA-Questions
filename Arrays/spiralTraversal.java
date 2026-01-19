public class spiralTraversal {
    // Traverse matrix in spiral order (clockwise)
    // Time Complexity: O(m*n)
    // Space Complexity: O(1)
    
    public static void printSpiral(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right along top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            
            // Traverse down along right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // Traverse left along bottom row (if exists)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            
            // Traverse up along left column (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    
    // Return spiral order as list
    public static java.util.List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        
        if (matrix.length == 0) return result;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Spiral traversal of 3x3 matrix:");
        printSpiral(matrix1); // Output: 1 2 3 6 9 8 7 4 5
        
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("Spiral traversal of 3x4 matrix:");
        printSpiral(matrix2); // Output: 1 2 3 4 8 12 11 10 9 5 6 7
        
        System.out.println("Spiral order as list: " + spiralOrder(matrix1));
    }
}
