public class MaxProductOfThreeNumbers {
    // Leetcode 628: https://leetcode.com/problems/maximum-product-of-three-numbers/

    public static void main(String[] args) {
        int[] nums = {1, -8, 6, 2, -5, 4, 8, 3, 7};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (min1 >= num) {
                min2 = min1;
                min1 = num;
            } else if (min2 > num) {
                min2 = num;
            }

            if (max1 <= num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 <= num) {
                max3 = max2;
                max2 = num;
            } else if (max3 < num) {
                max3 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

}
