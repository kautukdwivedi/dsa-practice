import java.io.*;
import java.util.*;

public class H {

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

    static void h(int x, int y) {
        out.append(x).append(' ').append(y).append(' ')
           .append(x).append(' ').append(y + 1).append(' ')
           .append(x + 1).append(' ').append(y).append('\n');
        out.append(x + 1).append(' ').append(y + 1).append(' ')
           .append(x + 2).append(' ').append(y + 1).append(' ')
           .append(x + 2).append(' ').append(y).append('\n');
    }

    static void v(int x, int y) {
        out.append(x).append(' ').append(y).append(' ')
           .append(x + 1).append(' ').append(y).append(' ')
           .append(x).append(' ').append(y + 1).append('\n');
        out.append(x + 1).append(' ').append(y + 1).append(' ')
           .append(x + 1).append(' ').append(y + 2).append(' ')
           .append(x).append(' ').append(y + 2).append('\n');
    }

    static void c(int x, int y) {
        out.append(x).append(' ').append(y).append(' ')
           .append(x).append(' ').append(y + 1).append(' ')
           .append(x + 1).append(' ').append(y).append('\n');
        out.append(x + 1).append(' ').append(y + 2).append(' ')
           .append(x + 2).append(' ').append(y + 1).append(' ')
           .append(x + 2).append(' ').append(y + 2).append('\n');
    }

    static void solve() throws Exception {

        int n = fs.nextInt();
        
        if (n % 2 == 0) {
            out.append(3 * n * n).append('\n');
            for (int i = 1; i <= 3 * n; i += 3) {
                for (int j = 1; j <= 3 * n; j += 2) {
                    h(i, j);
                }
            }
        } else {
            out.append(3 * n * n - 1).append('\n');
            for (int i = 1; i <= 3 * n; i += 3) {
                for (int j = 1; j <= 3 * n - 3; j += 2) {
                    h(i, j);
                }
            }
            for (int i = 1; i <= 3 * n - 3; i += 2) {
                for (int j = 3 * n - 2; j <= 3 * n; j += 3) {
                    v(i, j);
                }
            }
            c(3 * n - 2, 3 * n - 2);
        }
    }
}