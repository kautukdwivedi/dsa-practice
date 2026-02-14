package Div2Round1079;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
            
                int[] pos = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    pos[val] = i;
                }
                
                boolean possible = true;
                int lastIndex = -1; 
                int lastVal = -1;
                
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    
                    if (!possible) continue;
                    
                    if (val != lastVal) {
                        int currIndex = pos[val];
                        
                        if (currIndex < lastIndex) {
                            possible = false;
                        }
                        
                        lastIndex = currIndex;
                        lastVal = val;
                    }
                }
                
                if (possible) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}