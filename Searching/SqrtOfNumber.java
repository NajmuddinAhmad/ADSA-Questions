public class SqrtOfNumber {
    // Find square root of a number using binary search
    // Time Complexity: O(log n)
    
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        long left = 1, right = x;
        long result = 1;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) result;
    }
    
    // Method to find sqrt with precision for floating point numbers
    public static double sqrtWithPrecision(double x, int precision) {
        if (x == 0) return 0;
        
        double low = 0, high = x;
        double result = x;
        
        while (high - low > Math.pow(10, -precision)) {
            double mid = low + (high - low) / 2;
            
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                result = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Square root of 4: " + mySqrt(4)); // Output: 2
        System.out.println("Square root of 8: " + mySqrt(8)); // Output: 2
        System.out.println("Square root of 16: " + mySqrt(16)); // Output: 4
        System.out.println("Square root of 25: " + mySqrt(25)); // Output: 5
        
        System.out.println("\nWith precision:");
        System.out.println("Square root of 2 (precision 5): " + sqrtWithPrecision(2, 5)); // Output: ~1.414...
    }
}
