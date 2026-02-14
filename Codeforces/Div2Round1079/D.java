package Div2Round1079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String s = next();
            if (s == null) return -1; 
            return Integer.parseInt(s);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            long ans = 0;
           
            int B = (int) Math.sqrt(n); 
           
            for (int x = 1; x <= B; x++) {
               
                for (int j = 1; j <= n; j++) {
                    long product = (long)x * a[j];
                    
                  
                    if (product < j) {
                        int i = j - (int)product;
                        if (a[i] == x) {
                            ans++;
                        }
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if (a[i] > B) {
                  
                    int max_y = (n - i) / a[i];
                    
                    for (int y = 1; y <= max_y; y++) {
                        int j = i + a[i] * y;
                        if (a[j] == y) {
                            ans++;
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}