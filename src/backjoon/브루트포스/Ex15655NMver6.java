package backjoon.브루트포스;

import java.io.IOException;
import java.util.Arrays;

public class Ex15655NMver6 {
    static int N, M;
    static int[] arr;
    static int[] input;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        N = read();
        M = read();

        input = new int[N];
        arr = new int[M];

        for(int i = 0; i < N; i++) {
        	input[i] = read();
        }
        Arrays.sort(input);
        dfs(0, 0);

        System.out.println(sb.toString());
    }

    public static void dfs(int SP, int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = SP; i < N; i++){
            arr[depth] = input[i];
            dfs(i + 1, depth + 1);
        }
    }



    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = 0;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
