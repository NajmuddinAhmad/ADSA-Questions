import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int[][] board = new int[M][N]; 
    int maxDominoes = maxDominoesOnBoard(board);
    System.out.println(maxDominoes);
    sc.close();
    }

    public static int maxDominoesOnBoard(int[][] board) {
        int M = board.length;
        int N = board[0].length;
        return (M * N) / 2;
    }
}