package Div3Round1080;

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

    static int[][] grid = new int[5][9];
    static int[][] ans5x9 = new int[15][6];
    static boolean precomputed = false;

    static boolean dfs(int id) {
        if (id == 15) return true;
        int cx = -1, cy = -1;
        outer: for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    cx = i; cy = j; break outer;
                }
            }
        }
        if (cx == -1) return true;

        if (cy + 1 < 9 && cx + 1 < 5 && grid[cx][cy + 1] == 0 && grid[cx + 1][cy] == 0) {
            grid[cx][cy] = grid[cx][cy + 1] = grid[cx + 1][cy] = 1;
            ans5x9[id][0] = cx; ans5x9[id][1] = cy;
            ans5x9[id][2] = cx; ans5x9[id][3] = cy + 1;
            ans5x9[id][4] = cx + 1; ans5x9[id][5] = cy;
            if (dfs(id + 1)) return true;
            grid[cx][cy] = grid[cx][cy + 1] = grid[cx + 1][cy] = 0;
        }

        if (cy + 1 < 9 && cx + 1 < 5 && grid[cx][cy + 1] == 0 && grid[cx + 1][cy + 1] == 0) {
            grid[cx][cy] = grid[cx][cy + 1] = grid[cx + 1][cy + 1] = 1;
            ans5x9[id][0] = cx; ans5x9[id][1] = cy;
            ans5x9[id][2] = cx; ans5x9[id][3] = cy + 1;
            ans5x9[id][4] = cx + 1; ans5x9[id][5] = cy + 1;
            if (dfs(id + 1)) return true;
            grid[cx][cy] = grid[cx][cy + 1] = grid[cx + 1][cy + 1] = 0;
        }

        if (cx + 1 < 5 && cy + 1 < 9 && grid[cx + 1][cy] == 0 && grid[cx + 1][cy + 1] == 0) {
            grid[cx][cy] = grid[cx + 1][cy] = grid[cx + 1][cy + 1] = 1;
            ans5x9[id][0] = cx; ans5x9[id][1] = cy;
            ans5x9[id][2] = cx + 1; ans5x9[id][3] = cy;
            ans5x9[id][4] = cx + 1; ans5x9[id][5] = cy + 1;
            if (dfs(id + 1)) return true;
            grid[cx][cy] = grid[cx + 1][cy] = grid[cx + 1][cy + 1] = 0;
        }

        if (cx + 1 < 5 && cy - 1 >= 0 && grid[cx + 1][cy] == 0 && grid[cx + 1][cy - 1] == 0) {
            grid[cx][cy] = grid[cx + 1][cy] = grid[cx + 1][cy - 1] = 1;
            ans5x9[id][0] = cx; ans5x9[id][1] = cy;
            ans5x9[id][2] = cx + 1; ans5x9[id][3] = cy;
            ans5x9[id][4] = cx + 1; ans5x9[id][5] = cy - 1;
            if (dfs(id + 1)) return true;
            grid[cx][cy] = grid[cx + 1][cy] = grid[cx + 1][cy - 1] = 0;
        }

        return false;
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
            if (n == 1) {
                out.append(2).append('\n');
                c(1, 1);
            } else {
                if (!precomputed) {
                    dfs(0);
                    precomputed = true;
                }
                
                out.append(3 * n * n).append('\n');
                
                for (int i = 0; i < 15; i++) {
                    int r1 = ans5x9[i][0], c1 = ans5x9[i][1];
                    int r2 = ans5x9[i][2], c2 = ans5x9[i][3];
                    int r3 = ans5x9[i][4], c3 = ans5x9[i][5];
                    out.append(c1 + 1).append(' ').append(r1 + 1).append(' ')
                       .append(c2 + 1).append(' ').append(r2 + 1).append(' ')
                       .append(c3 + 1).append(' ').append(r3 + 1).append('\n');
                }
                
                for (int x = 10; x <= 3 * n; x += 3) {
                    h(x, 1);
                }
                
                for (int x = 10; x <= 3 * n; x += 2) {
                    v(x, 3);
                }
                
                for (int y = 6; y <= 3 * n; y += 2) {
                    for (int x = 1; x <= 3 * n; x += 3) {
                        h(x, y);
                    }
                }
            }
        }
    }
}