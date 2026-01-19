// Codeforces Problem 4A - Watermelon
// Link: https://codeforces.com/problemset/problem/4/A
// Problem: Given weight w (even number). Check if it can be divided into 2 positive parts equally.
// Answer "YES" if even, "NO" if odd (and w > 2)

import java.util.Scanner;

public class Codeforces4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int w = sc.nextInt();
        
        // Weight must be even and greater than 2
        if (w % 2 == 0 && w > 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        sc.close();
    }
    
    // Test case explanation:
    // Input: 2 -> Output: NO (cannot divide 2 into 2 positive parts)
    // Input: 4 -> Output: YES (can divide into 2+2)
    // Input: 3 -> Output: NO (odd number)
    // Input: 8 -> Output: YES (can divide into 4+4)
    
    public static void testCodeforces4A() {
        System.out.println("Sample Test Cases:");
        System.out.println("Input: 2 -> Output: NO");
        System.out.println("Input: 4 -> Output: YES");
        System.out.println("Input: 3 -> Output: NO");
        System.out.println("Input: 8 -> Output: YES");
    }
}
