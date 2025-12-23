import java.util.Arrays;

public class majority {
    // We solve this Question by using sort why using sort as we know when we sort the element higher/lower values is comes in start and so on 
//here in the Quesion there is only two values given in the array so when we sorting the array all the element in array get sorted and we know the one element in majority is it also come as mid element also ... 

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int first = 0;
        int last = nums.length;
        int mid = (first + last) / 2;
        return nums[mid];
    }
}
}
