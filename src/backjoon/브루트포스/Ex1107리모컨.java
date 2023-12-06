package backjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1107리모컨 {
    static int N, M, N_length;
    static boolean[] broken;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N_length = numberOfDigits(N);
        M = Integer.parseInt(br.readLine());
        min = Math.abs(N - 100);
        broken = new boolean[10];

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    public static int numberOfDigits(int num) {
        num = Math.abs(num);
        return String.valueOf(num).length();
    }

    public static void dfs(int click, int num) {
        if(click > 6){
            return;
        }
        if(click > 0){
            int currentNum = click + Math.abs(N - num);
            min = Math.min(min, currentNum);
        }

        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                dfs(click + 1, num * 10 + i);
            }
        }

    }
}
