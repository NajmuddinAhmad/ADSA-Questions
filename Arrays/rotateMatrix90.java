public class rotateMatrix90 {
    // Rotate matrix 90 degrees clockwise
    // Time Complexity: O(m*n)
    // Space Complexity: O(1)
    
    // Method 1: Transpose + Reverse (In-place)
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    // Method 2: Rotate layer by layer
    public static void rotateLayerByLayer(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n / 2; i++) {
            int first = i;
            int last = n - 1 - i;
            
            for (int j = first; j < last; j++) {
                int offset = j - first;
                
                // Save top
                int top = matrix[first][j];
                
                // Left to top
                matrix[first][j] = matrix[last - offset][first];
                
                // Bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                
                // Right to bottom
                matrix[last][last - offset] = matrix[j][last];
                
                // Top to right
                matrix[j][last] = top;
            }
        }
    }
    
    // Helper method to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Original matrix:");
        printMatrix(matrix);
        
        rotate(matrix);
        System.out.println("\nAfter 90 degree clockwise rotation:");
        printMatrix(matrix);
        
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        System.out.println("\nOriginal 4x4 matrix:");
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("\nAfter 90 degree clockwise rotation:");
        printMatrix(matrix2);
    }
}
