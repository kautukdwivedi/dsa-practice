package Div3Round1080;

import java.io.*;
import java.util.*;

public class A {

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
        boolean ok = false;

        for (int i = 0; i < n; i++) {
            int val = fs.nextInt();
            if (val == 67) {
                ok = true;
            }
        }

        if (ok) {
            out.append("YES\n");
        } else {
            out.append("NO\n");
        }
    }
}