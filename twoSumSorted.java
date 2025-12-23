public class twoSumSorted {
    class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1; 
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1 ,j+1};  // (i+1 ,J+1) is used beacouse in the question is given the index of array is started from 1 and we know in java and most of the programing languages index start from 0 so that why we are adding +1 in i and j
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{-1 ,-1};
    }
}
}
