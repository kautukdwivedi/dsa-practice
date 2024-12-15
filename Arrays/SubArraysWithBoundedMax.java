public class SubArraysWithBoundedMax {

    // Leetcode 169: https://leetcode.com/problems/majority-element/

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(numSubarrayBoundedMax(nums, 3, 8));
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int end = -1, start = -1, count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < left){
                count += end - start;
            }else if(nums[i] > right){
                start = i;
                end = i;
            }else{
                end = i;
                count += end - start;
            }
        }
        return count;
    }
}
