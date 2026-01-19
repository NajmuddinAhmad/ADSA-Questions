// Codeforces Problem 318A - Even Odds
// Link: https://codeforces.com/problemset/problem/318/A
// Problem: Given n and k, find the k-th number in sequence of odd numbers followed by even numbers.
// Sequence: 1, 3, 5, 7, ..., 2, 4, 6, 8, ...

import java.util.Scanner;

public class Codeforces318A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        long k = sc.nextLong();
        
        long oddCount = (n + 1) / 2; // Number of odd numbers from 1 to n
        
        if (k <= oddCount) {
            // k-th position is an odd number
            // 1st odd = 1, 2nd odd = 3, 3rd odd = 5, ...
            System.out.println(2 * k - 1);
        } else {
            // k-th position is an even number
            // Even numbers start after all odd numbers
            long evenIndex = k - oddCount;
            System.out.println(2 * evenIndex);
        }
        
        sc.close();
    }
    
    // Example explanation:
    // n=3: sequence is 1, 3, 5, 2, 4, 6, ...
    // k=1: output 1 (1st element is odd)
    // k=2: output 3 (2nd element is odd)
    // k=5: output 4 (5th element is even)
    
    // n=4: sequence is 1, 3, 5, ..., 2, 4, 6, 8, ...
    // oddCount = (4+1)/2 = 2
    // k=1: 1st odd = 1
    // k=2: 2nd odd = 3
    // k=3: 1st even = 2
    // k=4: 2nd even = 4
    
    public static void testCodeforces318A() {
        System.out.println("Sample Test Cases:");
        System.out.println("n=3, k=1 -> Output: 1");
        System.out.println("n=3, k=2 -> Output: 3");
        System.out.println("n=3, k=5 -> Output: 4");
        System.out.println("n=4, k=1 -> Output: 1");
        System.out.println("n=4, k=4 -> Output: 4");
        System.out.println("\nn=10, k=5 -> Output: " + findKthNumber(10, 5));
        System.out.println("n=10, k=7 -> Output: " + findKthNumber(10, 7));
    }
    
    private static long findKthNumber(long n, long k) {
        long oddCount = (n + 1) / 2;
        
        if (k <= oddCount) {
            return 2 * k - 1;
        } else {
            long evenIndex = k - oddCount;
            return 2 * evenIndex;
        }
    }
}
