// GFG: Leaders in an Array
// Link: https://www.geeksforgeeks.org/leaders-in-an-array/
// Brief: Find all elements greater than or equal to everything on their right by scanning from the end.
import java.util.ArrayList;
import java.util.Collections;

public class leader {
    class Solution {
        static ArrayList<Integer> leaders(int arr[]) {
            ArrayList<Integer> result = new ArrayList<>();
            int n = arr.length;
            int max = arr[n - 1];
            result.add(max);
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] >= max) {   
                    max = arr[i];
                    result.add(max);
                }
            }
            Collections.reverse(result);
            return result;
        }
    }
}
