import java.util.Arrays;

public class SquareOfSortedArray {
    // Leetcode 977: https://leetcode.com/problems/squares-of-a-sorted-array/

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        int idx = nums.length - 1;

        while (idx >= 0) {

            ans[idx] = Math.max(nums[left] * nums[left], nums[right] * nums[right]);

            if (ans[idx] == nums[left] * nums[left]) {
                left++;
            } else {
                right--;
            }

            idx--;
        }

        return ans;
    }
}
