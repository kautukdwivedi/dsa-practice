package Div2Round1079;

import java.util.*;
 
public class A {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0)
        {
            int n = scn.nextInt();
            int flag = 0;
 
            for(int i = 1; i <+ 81; i++){
                int y = n + i;
                int sum = getSum(y);
                if(y - sum == n){
                    System.out.println(10);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                System.out.println(0);
            }
        }    
    }
 
    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}