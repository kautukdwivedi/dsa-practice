package Div3Round1080;

import java.io.*;
import java.util.*;

public class C {

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int t = 1;
        t = fs.nextInt();

        while (t-- > 0) {
            solve();
        }

        System.out.print(out);
    }

    static void solve() throws Exception {

        int n = fs.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        int[] dp = new int[7];
        
        for (int i = 0; i < n; i++) {
            int[] ndp = new int[7];
            Arrays.fill(ndp, Integer.MAX_VALUE);
            
            for (int j = 1; j <= 6; j++) {
                int c = (arr[i] == j) ? 0 : 1;
                
                if (i == 0) {
                    ndp[j] = c;
                } else {
                    for (int k = 1; k <= 6; k++) {
                        if (j != k && j + k != 7) {
                            ndp[j] = Math.min(ndp[j], dp[k] + c);
                        }
                    }
                }
            }
            dp = ndp;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            ans = Math.min(ans, dp[i]);
        }

        out.append(ans).append('\n');
    }
}