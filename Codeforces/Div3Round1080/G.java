package Div3Round1080;

import java.io.*;
import java.util.*;

public class G {

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
        int q = fs.nextInt();
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];
        int[] p = new int[n + 1];
        int[] deg = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            L[i] = fs.nextInt();
            R[i] = fs.nextInt();
            if (L[i] != 0) { p[L[i]] = i; deg[i]++; }
            if (R[i] != 0) { p[R[i]] = i; deg[i]++; }
        }

        int[] qArr = new int[n + 1];
        int head = 0, tail = 0;
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) qArr[tail++] = i;
        }

        long[] w = new long[n + 1];
        while (head < tail) {
            int u = qArr[head++];
            if (L[u] == 0 && R[u] == 0) {
                w[u] = 1;
            } else {
                w[u] = w[L[u]] + w[R[u]] + 3;
            }
            int par = p[u];
            if (par != 0) {
                deg[par]--;
                if (deg[par] == 0) {
                    qArr[tail++] = par;
                }
            }
        }

        int[] tour = new int[(int) w[1]];
        int[] pos = new int[n + 1];
        int[] st = new int[n + 1];
        int curr = 1, idx = 0;

        while (curr != 0) {
            if (st[curr] == 0) {
                pos[curr] = idx;
                tour[idx++] = curr;
                if (L[curr] != 0) {
                    st[curr] = 1;
                    curr = L[curr];
                } else {
                    curr = p[curr];
                }
            } else if (st[curr] == 1) {
                tour[idx++] = curr;
                if (R[curr] != 0) {
                    st[curr] = 2;
                    curr = R[curr];
                }
            } else if (st[curr] == 2) {
                tour[idx++] = curr;
                curr = p[curr];
            }
        }

        int log = 20;
        int[][] up = new int[log][n + 1];
        long[][] sum = new long[log][n + 1];

        for (int i = 1; i <= n; i++) {
            up[0][i] = p[i];
            sum[0][i] = w[i];
        }

        for (int j = 1; j < log; j++) {
            for (int i = 1; i <= n; i++) {
                int nxt = up[j - 1][i];
                if (nxt != 0) {
                    up[j][i] = up[j - 1][nxt];
                    sum[j][i] = sum[j - 1][i] + sum[j - 1][nxt];
                } else {
                    up[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int v = fs.nextInt();
            long k = fs.nextLong();

            for (int j = log - 1; j >= 0; j--) {
                if (up[j][v] != 0 && k >= sum[j][v]) {
                    k -= sum[j][v];
                    v = up[j][v];
                }
            }
            out.append(tour[pos[v] + (int) k]).append(" ");
        }
        out.append('\n');
    }
}