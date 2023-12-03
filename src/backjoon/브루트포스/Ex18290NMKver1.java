package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Ex18290NMKver1 {
    static int N, M, K, sum = 0;
    static int[][] arr;
    static int[][] visited;
    static int Max_Val, Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                Max_Val = Math.max(Max_Val, arr[i][j]);
            }
        }

        visited = new int[N + 2][M + 2];
        dfs(0);
        System.out.println(Max);
    }

    public static void dfs(int depth) {

        if(Max_Val * (K - depth) + sum < Max) return;
        if (depth == K) {
            Max = Math.max(Max, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j] == 0) {
                    makeVisited(i, j, true);
                    sum += arr[i][j];
                    dfs(depth + 1);
                    sum -= arr[i][j];
                    makeVisited(i, j, false);
                }
            }
        }
    }

    public static void makeVisited(int x, int y, boolean PlusOrMinus) {
        if (PlusOrMinus) {
            visited[x][y] += 1;
            visited[x + 1][y] += 1;
            visited[x - 1][y] += 1;
            visited[x][y + 1] += 1;
            visited[x][y - 1] += 1;
            return;
        }
            visited[x][y] -= 1;
            visited[x + 1][y] -= 1;
            visited[x - 1][y] -= 1;
            visited[x][y + 1] -= 1;
            visited[x][y - 1] -= 1;
    }

}


