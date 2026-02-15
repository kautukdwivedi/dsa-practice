package Div3Round1080;

import java.io.*;
import java.util.*;

public class E {

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
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        int[] p = new int[n + 1];
        int[] deg = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            l[i] = fs.nextInt();
            r[i] = fs.nextInt();
            if (l[i] != 0) { p[l[i]] = i; deg[i]++; }
            if (r[i] != 0) { p[r[i]] = i; deg[i]++; }
        }

        int[] q = new int[n + 1];
        int head = 0, tail = 0;
        
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) q[tail++] = i;
        }

        long[] w = new long[n + 1];
        long MOD = 1000000007;

        while (head < tail) {
            int u = q[head++];
            if (l[u] == 0 && r[u] == 0) {
                w[u] = 1;
            } else {
                w[u] = (w[l[u]] + w[r[u]] + 3) % MOD;
            }
            int par = p[u];
            if (par != 0) {
                deg[par]--;
                if (deg[par] == 0) {
                    q[tail++] = par;
                }
            }
        }

        long[] ans = new long[n + 1];
        ans[1] = w[1];
        head = 0; tail = 0;
        q[tail++] = 1;

        while (head < tail) {
            int u = q[head++];
            if (l[u] != 0) {
                ans[l[u]] = (ans[u] + w[l[u]]) % MOD;
                q[tail++] = l[u];
            }
            if (r[u] != 0) {
                ans[r[u]] = (ans[u] + w[r[u]]) % MOD;
                q[tail++] = r[u];
            }
        }

        for (int i = 1; i <= n; i++) {
            out.append(ans[i]).append(i == n ? "" : " ");
        }
        out.append('\n');
    }
}