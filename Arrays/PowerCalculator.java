public class PowerCalculator {
    // Leetcode 169: https://leetcode.com/problems/majority-element/

    public static void main(String[] args) {
        int num = 4;
        int pow = 4;
        System.out.println(power(num, pow));
        System.out.println(Math.pow(num, pow));
    }

    public static long power(long num, long pow){
        if(pow == 0){
            return 1;
        }

        long res = 1;
        while(pow > 0){
            if(pow%2 == 1){
                res = res*num;
                pow--;
            }
            num = num*num;
            pow = pow/2;
        }
        return res;
    }
}
