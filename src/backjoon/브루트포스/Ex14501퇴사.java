package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14501퇴사 {
    static int N, Max = 0, sum = 0, element = Integer.MIN_VALUE;
    static int[] Time, Pay;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Time = new int[N];
        Pay = new int[N];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Time[i] = Integer.parseInt(st.nextToken());
            Pay[i] = Integer.parseInt(st.nextToken());
            element = Math.max(element, Pay[i]);
        }

        dfs(0, 0);
        System.out.println(Max);
    }

    public static void dfs(int depth, int sum) {
        if (Max > sum + element * (N - depth)) return;

        for (int i = depth; i < N; i++) {
            if (i + Time[i] <= N) {
                dfs(i + Time[i], sum + Pay[i]);
            }
            depth++;
        }

        if (depth == N) {
            Max = Math.max(Max, sum);
            return;
        }
    }

}
