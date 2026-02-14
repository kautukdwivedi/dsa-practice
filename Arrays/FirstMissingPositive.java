import java.util.Arrays;

public class FirstMissingPositive {

    // Leetcode 169: https://leetcode.com/problems/majority-element/

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] < len){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 1; i < len; i++){
            if(i != nums[i]){
                return i;
            }
        }

        return len;
    }
}
