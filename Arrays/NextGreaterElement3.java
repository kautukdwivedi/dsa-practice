public class NextGreaterElement3 {
    // Leetcode 556: https://leetcode.com/problems/next-greater-element-iii/

    public static void main(String[] args) {
        int num = 43697532;
        System.out.println(nextGreaterElement(num));
    }

    public static int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;
        int i = len - 2, j = len - 1;

        // Step 1: Find first non-increasing number
        while (i >= 0) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
            i--;
        }

        if (i == -1) {
            return -1;
        }

        // Step 2: Find just greater element
        while (j > 1) {
            if (digits[j] > digits[i]) {
                break;
            }
            j--;
        }

        // Step 3: Swap and Reverse remaining numbers
        swap(digits, i, j);
        reverse(digits, i + 1);

        return Long.parseLong(String.valueOf(digits)) > Integer.MAX_VALUE ? -1 : Integer.parseInt(String.valueOf(digits));
    }

    public static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void reverse(char[] digits, int i) {
        int left = i;
        int right = digits.length - 1;

        while (left < right) {
            swap(digits, left, right);
            left++;
            right--;
        }
    }
}
