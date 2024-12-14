public class LargestNumberAtLeastTwiceOfOthers {

    // Leetcode 747: https://leetcode.com/problems/largest-number-at-least-twice-of-others/

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int maxIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            }else if(nums[i] > secondMax){
                secondMax = nums[i];
            }
        }

        return max >= 2*secondMax ? maxIndex : -1;
    }
}
