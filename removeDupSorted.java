public class removeDupSorted {
    class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int result = 1;
        while(j < n){

            if(nums[j] == nums[j-1]){
                j++;
            }
            else if(nums[j] != nums[j-1]){
                nums[i+1] = nums[j];
                result++;
                i++;
                j++;
            }
        }
        return result;
    }
}
}
