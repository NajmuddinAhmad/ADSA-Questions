import java.util.*;

public class prefixsum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result1 = runningSum(nums);
        System.out.println(Arrays.toString(result1));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
