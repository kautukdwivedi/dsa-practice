package Div3Round1080;

import java.io.*;
import java.util.*;

public class F {

    static class NodeastScanner {
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

    static NodeastScanner fs = new NodeastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int t = 1;
        t = fs.nextInt();

        while (t-- > 0) {
            solve();
        }

        System.out.print(out);
    }

    static class Node implements Comparable<Node> {
        long a, b, c;
        int id;

        Node(long a, long b, long c, int id) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.id = id;
        }

        public int compareTo(Node o) {
            if (this.a != o.a) return Long.compare(this.a, o.a);
            if (this.b != o.b) return Long.compare(this.b, o.b);
            return Long.compare(this.c, o.c);
        }
    }

    static boolean isValid(Node u, Node v) {
        long A = v.a - u.a;
        long B = v.b - u.b;
        long C = v.c - u.c;

        if (A == 0) {
            return B == 0 && C > 0;
        } else if (A > 0) {
            return B * B < 4L * A * C;
        }
        return false;
    }

    static void solve() throws Exception {

        int n = fs.nextInt();
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(fs.nextLong(), fs.nextLong(), fs.nextLong(), i);
        }

        Arrays.sort(arr);

        int[] dpIn = new int[n];
        int[] dpOut = new int[n];

        for (int i = 0; i < n; i++) {
            dpIn[i] = 1;
            for (int j = 0; j < i; j++) {
                if (isValid(arr[j], arr[i])) {
                    dpIn[i] = Math.max(dpIn[i], dpIn[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dpOut[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (isValid(arr[i], arr[j])) {
                    dpOut[i] = Math.max(dpOut[i], dpOut[j] + 1);
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[arr[i].id] = dpIn[i] + dpOut[i] - 1;
        }

        for (int i = 0; i < n; i++) {
            out.append(ans[i]).append(i == n - 1 ? "" : " ");
        }
        out.append('\n');
    }
}