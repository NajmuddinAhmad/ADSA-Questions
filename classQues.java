// LeetCode 238. Product of Array Except Self
// Brief: For each index, compute product of all other elements. This version is O(n^2); optimal uses prefix/suffix products in O(n) without division.
// Question :- given an array {1,2,3,4} find a product array where each element is the product of all elements except itself
import java.util.*;
public class classQues {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] result = Product(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] Product(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    prod *= arr[j];
                }
            }
            result[i] = prod;
        }
        return result;
    }

    static void maxElement(int [] arr , int target){
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
    }
}
