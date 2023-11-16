package backjoon.DFSBFS;

/**
 * P1260
 */
public class P1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[][] map;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws Exception {
        N = read();
        map = new boolean[N + 1][N + 1];
        int M = read(), V = read();

        while (M-- > 0) {
            int from = read(), to = read();
            map[from][to] = map[to][from] = true;
        }

        visited = new boolean[N + 1];
        dfs(V);

        sb.append('\n');

       visited = new boolean[N + 1];
       bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');

        for (int i = 1; i <= N; i++) {
            if (map[v][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        int[] queue = new int[N];
        int head = 0, tail = -1;
        visited[v] = true;
        queue[++tail] = v;

        while (tail - head + 1 > 0) {
            v = queue[head++];
            sb.append(v).append(' ');

            for (int i = 1; i <= N; i++) {
                if (map[v][i] && !visited[i]) {
                    visited[i] = true;
                    queue[++tail] = i;
                }
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}