public class spiralMatrix {
    // Generate spiral matrix of size n x n
    // Time Complexity: O(n*n)
    // Space Complexity: O(n*n)
    
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        
        while (top <= bottom && left <= right) {
            // Fill right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
            // Fill down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Fill left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            
            // Fill up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }
    
    // Helper method to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Spiral matrix of size 3x3:");
        int[][] matrix3 = generateMatrix(3);
        printMatrix(matrix3);
        
        System.out.println("\nSpiral matrix of size 4x4:");
        int[][] matrix4 = generateMatrix(4);
        printMatrix(matrix4);
        
        System.out.println("\nSpiral matrix of size 5x5:");
        int[][] matrix5 = generateMatrix(5);
        printMatrix(matrix5);
    }
}
