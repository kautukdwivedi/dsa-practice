import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    // Leetcode 229: https://leetcode.com/problems/majority-element-ii/

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 = -1;
        int len = nums.length;

        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num1 == num) {
                count1++;
            } else if (num2 == num) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        if (count1 > len / 3) {
            ans.add(num1);
        }
        if (count2 > len / 3) {
            ans.add(num2);
        }
        return ans;
    }
}
