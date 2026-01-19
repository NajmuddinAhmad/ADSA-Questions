public class validSudoku {
    // Check if Sudoku board is valid (LeetCode 36)
    // Time Complexity: O(1) - constant grid size 9x9
    // Space Complexity: O(1)
    
    public static boolean isValidSudoku(char[][] board) {
        // Check rows, columns, and 3x3 sub-boxes
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidBox(board, i)) {
                return false;
            }
        }
        return true;
    }
    
    // Check if a specific row is valid
    private static boolean isValidRow(char[][] board, int row) {
        java.util.Set<Character> seen = new java.util.HashSet<>();
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c != '.') {
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }
    
    // Check if a specific column is valid
    private static boolean isValidColumn(char[][] board, int col) {
        java.util.Set<Character> seen = new java.util.HashSet<>();
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c != '.') {
                if (seen.contains(c)) {
                    return false;
                }
                seen.add(c);
            }
        }
        return true;
    }
    
    // Check if a specific 3x3 box is valid
    private static boolean isValidBox(char[][] board, int boxIndex) {
        java.util.Set<Character> seen = new java.util.HashSet<>();
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;
        
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (seen.contains(c)) {
                        return false;
                    }
                    seen.add(c);
                }
            }
        }
        return true;
    }
    
    // Alternative optimized single-pass solution
    public static boolean isValidSudokuOptimized(char[][] board) {
        java.util.Set<String> seen = new java.util.HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    // Check row
                    if (!seen.add(c + "row" + i)) return false;
                    // Check column
                    if (!seen.add(c + "col" + j)) return false;
                    // Check 3x3 box
                    if (!seen.add(c + "box" + (i/3) + (j/3))) return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is valid sudoku (board1): " + isValidSudoku(board1)); // true
        
        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Is valid sudoku (board2): " + isValidSudoku(board2)); // false
    }
}
