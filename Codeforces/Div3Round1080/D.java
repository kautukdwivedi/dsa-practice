package Div3Round1080;

import java.io.*;
import java.util.*;

public class D {

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
        long[] f = new long[n];
        
        for (int i = 0; i < n; i++) {
            f[i] = fs.nextLong();
        }

        long s = (f[0] + f[n - 1]) / (n - 1);
        long[] d = new long[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            d[i] = f[i + 1] - f[i];
        }

        long[] a = new long[n];
        a[0] = (s + d[0]) / 2;
        a[n - 1] = (s - d[n - 2]) / 2;

        for (int i = 1; i < n - 1; i++) {
            a[i] = (d[i] - d[i - 1]) / 2;
        }

        for (int i = 0; i < n; i++) {
            out.append(a[i]).append(i + 1 == n ? "" : " ");
        }
        out.append('\n');
    }
}