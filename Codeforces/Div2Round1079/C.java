package Div2Round1079;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        if (scn.hasNextInt()) {
            int t = scn.nextInt();
            
            while (t-- > 0) {
                long p = scn.nextLong();
                long q = scn.nextLong();
                
                if (3 * p == 2 * q) {
                    System.out.println("Bob");
                } else if (3 * p < 2 * q) {
                    System.out.println("Alice");
                } else {
                    if (q > p) {
                        System.out.println("Bob");
                    } else {
                        System.out.println("Alice");
                    }
                }
            }
        }
        scn.close();
    }
}