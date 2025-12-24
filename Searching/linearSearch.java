// Basic: Linear Search
// Brief: Scan array sequentially to find target in O(n).
public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 9, 1, 4};
        int target = 9;
        Lsearch(arr, target);
        // int ans = lsearch(arr, target);
        // System.out.println(ans);

    }

    // By using void melthod mean there is no return type we print our answer

    static void Lsearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == target) {
                System.out.println("The target element found at index :" + i);
                return; 
            }
        }
        System.out.println("The target element is not present in the given array");
    }

    // By using return melthod and returning only integer value 
//         static int lsearch(int[] arr, int target) {
//             for (int i = 0; i < arr.length; i++) {
//                 if (arr[i] == target) {
//                     return i;
//                 }
//             }
//             return -1;
//         }
}
