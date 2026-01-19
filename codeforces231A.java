// Codeforces Problem 231A - Team
// Link: https://codeforces.com/problemset/problem/231/A
// Problem: Given n problems and 3 people solving them. Each person can solve or not.
// Count problems where at least 2 people solved it.

import java.util.Scanner;

public class Codeforces231A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            int p3 = sc.nextInt();
            
            if (p1 + p2 + p3 >= 2) {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
    
    // Test case
    public static void testCodeforces231A() {
        // Input:
        // 3
        // 1 1 0
        // 1 0 0
        // 1 1 1
        // Output: 2
        // Explanation: First and third problems have at least 2 people solving
        
        System.out.println("Sample Input:");
        System.out.println("3");
        System.out.println("1 1 0");
        System.out.println("1 0 0");
        System.out.println("1 1 1");
        System.out.println("Sample Output: 2");
    }
}
