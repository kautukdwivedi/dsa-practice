public class MajorityElement1 {
    // Leetcode 169: https://leetcode.com/problems/majority-element/

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;

        for (int num : nums) {
            if (count == 0) {
                ele = num;
                count = 1;
            } else if (ele == num) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }
}
