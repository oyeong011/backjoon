package backjoon.브루트포스;

import java.io.IOException;

public class Ex15652N과Mver4 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = read();
        M = read();

        arr = new int[M];
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
            arr[depth] = i + 1;
            dfs(i, depth + 1);
        }
    }






    public static int read() throws IOException{
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = 0;
        while ((c = System.in.read()) > 32) n = 10 * n + (c & 15);
        if(c == 13) System.in.read();
        return isNegative ? ~n + 1 : n;
    }
}
