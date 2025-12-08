public class binarySearch {
        public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7};
        int target = 5;
        int ans = BinarySearch(arr, target);
        System.out.println(ans);

    }
    static int BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
