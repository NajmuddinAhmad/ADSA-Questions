// Basic: Find maximum element in an array
// Brief: Linear scan to track the largest value.
public class maxElement {
    public static void main(String[] args) {
        int [] arr = {8, 9, 2 , 5 ,15 , 6 , 7};
        MaxElement(arr);
    }
    static void MaxElement(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
