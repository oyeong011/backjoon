package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex15654NMver5 {
    static int N, M;
    static int[] arr;
    static int[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        visited = new boolean[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else{
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


}
